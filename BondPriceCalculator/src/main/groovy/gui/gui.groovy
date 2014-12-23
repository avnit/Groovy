package main.groovy.gui

import groovy.swing.SwingBuilder
import org.apache.commons.logging.Log

import javax.swing.*
import java.awt.*

/**
 * Created by avnitbambah on 11/23/14.
 */
class gui {

    public static void main(String[] args) {
        // create a swing builder gui

        SwingBuilder sw
        sw = new SwingBuilder()

        // def model = new Model()
        def output
        def value_interest_rate
        def frame
        frame = sw.frame(title: "Groovy SwingBuilder MVC Demo", size: [500, 580], visible: true,
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {
            gridLayout(rows: 10, cols: 10)
            label("Par")
            //  context("Input data here for Future value ")
            label("rate")
            label("YTM")


            label 'Par Value '

            input = textField(columns: 10,
                    actionPerformed: { output.text = input.text })
            label 'interest rate'
            interest_rate = textField(columns: 10, actionPerformed: { value_interest_rate = interest_rate.text })

            label 'Echo: '

            output = label()

        }

        println( "Entered value is retained outside the loop")


        JPanel j = new JPanel(new GridBagLayout())
        JMenu jm = new JMenu()
        JMenuBar jmb = new JMenuBar()
        JButton JB = new JButton("File")
        jmb.add(JB)
        JButton JB_Edit = new JButton("Edit")
        jmb.add(JB_Edit)

        jm.add(jmb)
        j.add(jm, -1)
        frame.add(j)
//        frame.visible()
        //      model.initialize([1.0, 0.83, 0.56]);
        // get inputs from gui

        //call bond calculator to produce bond price and effective rate

        //call service to expose the output

        //update gui with data.

    }
}