TXT FILE STRUCTURE

Employee: EID|name|email|address|phone_num|role|password| 

STUDENT: SID|name|email|address|phone_num|role|date_registered|password

INSTRUCTOR RATING: RID|EID|RATING|Rated_by

PAYMENT: PID|Student_Name|Amount|date|status|method|UID|CID

EQUIPMENT: EID|E_name|category|stock|FID

FACILITY: FID|name|venue|open_hour|close_hour

CLASS: CID|UID|name|time_start|time_end|number_of_students|Class Price|FID

ATTENDANCE: Schedule_ID|CID|SID|date|status

EQUIPMENT REPORT: ER_ID|UID|Report Date|Title|Report content|status

FACILITY REPORT: FR_ID|FID|Report_Date|Title|Report Content|status


LEGEND

DATE FORMAT: YYYY-MM-DD

TIME FORMAT = HH:MM 24 hours format

EID = Employee ID

SID = Student ID

CID = Class ID (Classes in the Gym)

FID = Faculty ID

ER_ID = Equipment Report ID

FR_ID = Facility Report ID

Payment Status = Pending, paid

payment method = Card, QR, Cash

Facility & Equipment Report Status = Pending, reviewed, solved

Attendance Status = Present, Late, Absent