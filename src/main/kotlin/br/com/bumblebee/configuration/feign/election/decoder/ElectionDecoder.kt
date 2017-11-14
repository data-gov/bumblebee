package br.com.bumblebee.configuration.feign.election.decoder

import br.com.bumblebee.api.election.client.model.PresidentElectionData
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableList.copyOf
import feign.Response
import feign.Util
import feign.codec.Decoder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Type

@Configuration
class
ElectionDecoder : Decoder {

    @Autowired private lateinit var mapper: CsvMapper

    override fun decode(response: Response, type: Type): ImmutableList<String> {
        val responseString = Util.toString(response.body()?.asReader())
        val responseObject = when (responseString) {
            null -> emptyList()
            else -> mapper.readerFor(PresidentElectionData::class.java)
                .with(CsvSchema.emptySchema().withHeader())
                .readValues<String>(responseString).readAll()
        }

        return copyOf(responseObject)
    }
}
