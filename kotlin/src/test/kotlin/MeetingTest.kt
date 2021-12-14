import org.junit.Test
import kotlin.test.assertEquals

class MeetingTest {
  @Test
  fun canary() {
    assert(true)
  }

  @Test
  fun firstLineOfDSL() {
    val result = schedule meeting {}

    assertEquals("Meeting scheduled", result)
  }

  @Test
  fun secondLineOfDSL() {
    val result = schedule meeting {
      meeting name "early admissions"
    }

    assertEquals(
      """Meeting scheduled
    for early admissions""", result
    )
  }

  @Test
  fun thirdLineOfDSL() {
    val result = schedule meeting {
      meeting name "early admissions"
      meeting starts 14.30
    }
    assertEquals(
      """Meeting scheduled
    for early admissions
    starts at 14:30""", result
    )
  }

  @Test
  fun fourthLineOfDSL() {
    val result = schedule meeting {
      meeting name "early admissions"
      meeting starts 14.30
      meeting ends 15.30
    }
    assertEquals(
      """Meeting scheduled
    for early admissions
    starts at 14:30
    ends at 15:30""", result
    )
  }

  @Test
  fun fifthLineOfDSL() {
    val result = schedule meeting {
      meeting name "early admissions"
      meeting starts 14.30
      meeting ends 15.30
      meeting month 10 day 15 of 2018
    }
    assertEquals(
      """Meeting scheduled
    for early admissions
    starts at 14:30
    ends at 15:30
    on 10/15/2018""", result
    )
  }

  @Test
  fun lastLineOfDSL() {
    val result = schedule meeting {
      meeting name "early admissions"
      meeting starts 14.30
      meeting ends 15.30
      meeting month 10 day 15 of 2018
      meeting.participants("Walker, R.", "Smith, K.", "Zou, L.", "Patel, D.")

    }
    assertEquals(
      """Meeting scheduled
    for early admissions
    starts at 14:30
    ends at 15:30
    on 10/15/2018
    participants {
      Walker, R.
      Smith, K.
      Zou, L.
      Patel, D.
    }""", result
    )
  }
}
