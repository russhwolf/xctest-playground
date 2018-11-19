package sample

import platform.Foundation.NSURL
import platform.Foundation.NSURLSession
import platform.Foundation.dataTaskWithURL
import platform.XCTest.XCTWaiter
import platform.XCTest.XCTestExpectation
import kotlin.test.Test
import kotlin.test.assertNotNull

class SampleTests {

    @Test
    fun xctest() {
        val expectation = XCTestExpectation()

        val url = NSURL(string = "https://apple.com")

        val dataTask = NSURLSession.sharedSession.dataTaskWithURL(url) { data, _, _ ->
            assertNotNull(data)

            expectation.fulfill()
        }

        dataTask.resume()

        XCTWaiter().waitForExpectations(listOf(expectation), 10.0)
    }

}
