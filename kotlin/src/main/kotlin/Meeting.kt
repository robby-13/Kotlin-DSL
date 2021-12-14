import java.nio.IntBuffer
import java.util.*
import java.util.stream.IntStream
import java.util.stream.Collectors

object schedule {
  infix fun meeting(block: Meeting.() -> Unit): String {
    val meeting = Meeting()
    meeting.block()
    return meeting.toString()
  }
}

class Meeting {
  val details = StringBuilder("Meeting scheduled")
  val meeting = this

  infix fun name(meetingName: String) {
    details.append("""
    for $meetingName""")
  }
  
  infix fun starts(meetingStart: Double) {
    val hours = meetingStart.toInt()
    val minutes = ((meetingStart - hours) * 100).toInt()
  
    details.append("""
    starts at $hours:$minutes""")
  }

  infix fun ends(meetingEnd: Double) {
    val hours = meetingEnd.toInt()
    val minutes = ((meetingEnd-hours) * 100).toInt()

    details.append("""
    ends at $hours:$minutes""")
  }

  infix fun month(meetingMonth: Int): Meeting {
    details.append("""
    on $meetingMonth""")
    return this
  }

  infix fun day(meetingDay: Int): Meeting {
    details.append("/$meetingDay")
    return this
  }

  infix fun of(meetingYear: Int) {
    details.append("/$meetingYear")
  }


  fun participants(vararg meetingParticipants: String) {
    val iterator = meetingParticipants.iterator()

    details.append("""
    participants {""")

    iterator.forEach { meetingParticipant ->
      details.append("""
      $meetingParticipant""")
    }

    details.append("""
    }""")
  }

  override fun toString() = details.toString()

}