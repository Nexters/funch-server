package kr.co.funch.api.supports.config.mongo

import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper
import org.springframework.data.mongodb.core.convert.MappingMongoConverter
import org.springframework.data.mongodb.core.convert.MongoCustomConversions
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Date

@Configuration
@EnableMongoAuditing
@EnableReactiveMongoRepositories("kr.co.funch")
class MongoDBConfig(
    mappingMongoConverter: MappingMongoConverter,
) {
    init {
        mappingMongoConverter.apply {
            setTypeMapper(DefaultMongoTypeMapper(null))
            customConversions =
                MongoCustomConversions(
                    listOf(
                        ZonedDateTimeToDateConverter(),
                        DateToZonedDateTimeConverter(),
                    ),
                )
            afterPropertiesSet()
        }
    }

    class ZonedDateTimeToDateConverter : Converter<ZonedDateTime, Date> {
        override fun convert(source: ZonedDateTime): Date {
            return Date.from(source.toInstant())
        }
    }

    class DateToZonedDateTimeConverter : Converter<Date, ZonedDateTime> {
        override fun convert(source: Date): ZonedDateTime {
            return source.toInstant().atZone(ZONE_ID)
        }
    }

    companion object {
        val ZONE_ID = ZoneId.of("Asia/Seoul")
    }
}
