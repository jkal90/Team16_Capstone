import mysql.connector
import csv

COL_HEADERS = { "nap_questions": ["Did you wake up during the day?", "1st Nap Start",
"1st Nap End", "2nd Nap Start", "2nd Nap End", "3rd Nap Start", "3rd Nap End"]}


def main():
    connection = mysql.connector.connect(host="35.188.230.66",
        user="root",
        password="ece480team16",
        database="patientdata")
    cursor = connection.cursor()

    cursor.execute("SELECT * FROM nap_questions")
    result = cursor.fetchall()

    result = [list(element) for element in result]
    connection.close()

    filename = "nap_questions.csv"
    with open(filename, 'w') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(COL_HEADERS["nap_questions"])
        csvwriter.writerows(result)

main()