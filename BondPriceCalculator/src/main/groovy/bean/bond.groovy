package main.groovy.bean

/**
 * Created by avnitbambah on 11/23/14.
 */
class bond {
    double present_value
    double face_value_of_bond
    double price
    double ytm
    double interest_rate
    double time_to_maturity
    int frequency
    int months_until_next_coupon
    // calculate price
    // if you need to calculate price then
    public calculatePresentValue() {
        //=(C4*C3/C5)*(1-(1+((1+C7)^(1/C5)-1))^(0-C6*C5))/((1+C7)^(1/C5)-1)+C3/(1+C7)^(C6+C9/12)+C3*C4/C5/(1+C7)^(C9/12)
        //Face Value of Bond = c3 = fv
        // Coupon Rate on Bond = c4 = rate
        //   Frequency of coupons = c5 = frequency
        // Time to Maturity = c6 = term
        //  Interest Rate on Bond  = c7 = rate
        //  If seasoned bond, enter the following c8
        // Months until next coupon = c9 =
        present_value = (interest_rate * face_value_of_bond / frequency) * (1 - 1 + ((1 + interest_rate)**(1 / frequency) - 1))**(0 - time_to_maturity * frequency) / (1 + interest_rate)**(1 / frequency) - 1 + face_value_of_bond / (1 + interest_rate)**(time_to_maturity + months_until_next_coupon / 12) + face_value_of_bond * interest_rate / frequency / (1 + interest_rate)**(months_until_next_coupon / 12)

        print "computed present value of bond is ${present_value}"

    }

    public double calculateEffectiveYield(double inflation_rate) {
        // ((1 + R ) = ( 1 + r ) ( 1 + h )
        // r = interest rate
        // R = effective rate
        // h = inflation rate ( input )
        double effective_rate = ((1 + interest_rate) * (1 + interest_rate)) - 1
        return effective_rate
    }


}


