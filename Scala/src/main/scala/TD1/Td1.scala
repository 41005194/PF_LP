package TD1

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Td1 {
    case class Information(message: String, country: String, timestamp: LocalDateTime, tags: List[String], price: Int)
    
    def parseInformation(line: String): Information = {
        val parts = line.split("--")
        val timestamp = parts(0).trim
        val country = parts(1).trim
        val message = parts(2).trim
        val tags = parts(3).split(",").map(_.trim).toList
        val price = parts(4).split("€")(0).trim.toInt
        Information(message, country, LocalDateTime.parse(timestamp, DateTimeFormatter.ISO_LOCAL_DATE_TIME), tags, price)
    }

    def informationTimestamps(info: List[Information]): List[LocalDateTime] = {
        info.map(_.timestamp)
    }

    def informationTag(info: List[Information], tag: String): List[Information] = {
        info.filter(_.tags.contains(tag))
    }

    def informationTagOneOf(info: List[Information], tags: List[String]): List[Information] = {
        info.filter(i => i.tags.exists(tags.contains))
    }

    def informationMessageSuchThat(info: List[Information], substring: String): List[Information] = {
        info.filter(_.message.contains(substring))
    }

    def informationCountry(info: List[Information], country: String): List[Information] = {
        info.filter(_.country == country)
    }

    def selection(info: List[Information], informationfilter: Information => Boolean, valeurChamps: Information => String): List[String] = {
        info.filter(informationfilter).map(valeurChamps)
    }

    val messageSelecteur: Information => String = _.message
    val countrySelecteur: Information => String = _.country
    val tagSelecteur: Information => String = _.tags.mkString(", ")
    val timestampSelecteur: Information => String = _.timestamp.toString


    def test(): Unit = {
        val rawInformation = List(
            "2017-05-08T14:39:06 -- France -- This is an information -- tag1 -- 2€",
            "2017-05-08T14:49:06 -- UK -- This is another information -- tag1,tag2 -- 4€",
            "2018-05-10T14:39:06 -- France -- This is a newer information -- tag3 -- 8€"
        )
        val information = rawInformation.map(parseInformation(_))

        println("Timestamps:")
        println(informationTimestamps(information))

        println("Informations contenant 'newer':")
        println(informationMessageSuchThat(information, "newer"))

        println("Informations commençant par 'This':")
        println(information.filter(_.message.startsWith("This")))

        println("Informations avec le tag 'tag1':")
        println(informationTag(information, "tag1"))

        println("Informations avec le tag 'tag2' ou 'tag3':")
        println(informationTagOneOf(information, List("tag2", "tag3")))

        println("Prix total des informations concernant la France:")
        val franceInfos = informationCountry(information, "France")
        println(franceInfos.map(_.price).sum)
    }

    def main(args: Array[String]): Unit = {
        test()
    }
}

