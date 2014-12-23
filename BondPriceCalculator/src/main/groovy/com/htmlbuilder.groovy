import groovy.xml.MarkupBuilder

/**
 * Created by avnitbambah on 11/25/14.
 * Add this to utils
 * This class will create an html builder by passing in header and row elements with deliminator.
 * call
 */

class htmlBuilder  {


    def writer = new StringWriter()  // html is written here by markup builder
    def markup = new groovy.xml.MarkupBuilder(writer)  // the builder
    def header
    def title
    def cssScript



public getSampleTemplate ( def headerStringCommaSep , def row , def rowSep , def recordSep ) {
    def headerArray = headerStringCommaSep.split(rowSep)
    def rowArray = row.split(recordSep)
    writer.html {
        head {
            title ("${header}")
            style ("type":"text/css",cssScript)
        }
        body {
            headerArray.each {
                th (class : "${headerClass}" , "${it}")
            }
            rowArray.each { $row ->
                tr {
                    $row.split(rowSep) {
                        td (class : "${rowClass}" , "${it}")
                    }
                }
            }
        }

    }






}





}
