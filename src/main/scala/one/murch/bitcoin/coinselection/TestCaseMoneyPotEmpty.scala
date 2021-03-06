package one.murch.bitcoin.coinselection

import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.util.Random

/**
  * Created by murch on 31.12.16.
  */
object TestCaseMoneyPotEmpty extends Scenario(Set(), ListBuffer(), "TESTCASE 12: Starts with empty wallet, then performs all operations from MoneyPot.com's data.") {
    val rnd = new Random()

    var index = 1
    var nLockTime = 1

    for (line <- Source.fromResource("scenarios/moneypot.csv").getLines()) {
        val nextOp: Long = (line).toLong
        nLockTime = math.max(0, ((rnd.nextGaussian() + 1) * 10).toInt) + nLockTime
        operations += new Payment(index, nextOp, nLockTime)
        index += 1
    }
}
