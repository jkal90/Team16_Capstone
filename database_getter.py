import mysql.connector
import csv

COL_HEADERS = { "wakeup_questions": ["Wake-Up Time", "Difficulty Sleeping", 
"Waking Up During Night", "Woke Up Too Early", "User ID"]}


def main():
    connection = mysql.connector.connect(host="35.188.230.66", 
        user="root", 
        password="ece480team16",
        database="patientdata")
    cursor = connection.cursor()

    cursor.execute("SELECT * FROM wakeup_questions")
    result = cursor.fetchall()

    result = [list(element) for element in result]
    for row in result:
        hours = str(row[0].seconds // 3600)
        minutes = (row[0].seconds % 3600) // 60
        if minutes < 10:
            minutes = '0' + str(minutes)
        else:
            minutes = str(minutes)
        row[0] = hours + ':' + minutes
    connection.close()

    filename = "wakeup_questions.csv"
    with open(filename, 'w') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(COL_HEADERS["wakeup_questions"])
        csvwriter.writerows(result)

main()