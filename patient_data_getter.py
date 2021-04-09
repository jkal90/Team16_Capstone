import mysql.connector
import csv

COL_HEADERS = { "wakeup_questions": 
["Wake-Up Time", "Difficulty Sleeping", "Waking Up During Night", "Woke Up Too Early", "User ID"],
"nap_questions": 
["Did you wake up during the day?", "1st Nap Start",
"1st Nap End", "2nd Nap Start", "2nd Nap End", "3rd Nap Start", "3rd Nap End", "User ID"],
"bedtime_questions": 
["Bed Time", "24-Hour Fatigue Level:", "Average Level of Sleepiness:", "User ID"] }

def get_connection():
    connection = mysql.connector.connect(host="35.188.230.66",
        user="root",
        password="ece480team16",
        database="patientdata")
    return connection

def main():
    connection = get_connection()
    cursor = connection.cursor()
    print("Welcome to the patient CSV getter.")
    user_in = input("Would you like data sorted by user_id? (y or n; if n, entries will be ordered by time received): ")
    user_in = user_in.lower()
    while user_in != 'y' and user_in != 'n':
        print("Invalid input, try again")
        user_in = input("Would you like data sorted by user_id? (y or n; if n, entries will be ordered by time received): ")
        user_in = user_in.lower()
    sort_by_user = user_in == 'y'

    
    for table in COL_HEADERS:
        query = "SELECT * FROM " + table
        if sort_by_user:
            query += " ORDER BY user_id"
        cursor.execute(query)
        result = cursor.fetchall()
        result = [list(element) for element in result]
        filename = "TABLE" + table + ".csv"
        with open(filename, 'w', newline='') as csvfile:
            csvwriter = csv.writer(csvfile)
            csvwriter.writerow(COL_HEADERS[table])
            csvwriter.writerow([])
            csvwriter.writerows(result)

    connection.close()

main()
