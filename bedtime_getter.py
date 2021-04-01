import mysql.connector
import csv

COL_HEADERS = { "bedtime_questions": ["Bed Time", "24-Hour Fatigue Level:",
"Average Level of Sleepiness:", "User ID"]}


def main():
    connection = mysql.connector.connect(host="35.188.230.66",
        user="root",
        password="ece480team16",
        database="patientdata")
    cursor = connection.cursor()

    cursor.execute("SELECT * FROM bedtime_questions")
    result = cursor.fetchall()

    result = [list(element) for element in result]
    connection.close()

    filename = "bedtime_questions.csv"
    with open(filename, 'w') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(COL_HEADERS["bedtime_questions"])
        csvwriter.writerows(result)

main()