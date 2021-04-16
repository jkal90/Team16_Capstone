import mysql.connector
import csv
import requests

COL_HEADERS = { "wakeup_questions": 
["Wake-Up Time", "Difficulty Sleeping", "Waking Up During Night", "Woke Up Too Early", "User ID"],
"nap_questions": 
["Did you take a nap during the day?", "1st Nap Start",
"1st Nap End", "2nd Nap Start", "2nd Nap End", "3rd Nap Start", "3rd Nap End", "User ID"],
"bedtime_questions": 
["Bed Time", "24-Hour Fatigue Level:", "Average Level of Sleepiness:", "User ID"],
"timer_usage":
["Start Time", "End Time", "User ID"] }

BASE_REQUEST = 'https://webdev.cse.msu.edu/~huangmax/ece480/ece480app/retrieve_data.php?table='

def main():
    for table in COL_HEADERS:
        query = BASE_REQUEST + table
        req = requests.get(query)
        response = req.text
        if response == "Failed":
            print("Failed to retrieve from table ", table)
            continue
        response = response.split('\n')
        response.pop()
        for i in range(len(response)):
            response[i] = response[i].split('|')
            response[i].pop()
        filename = "TABLE" + table + ".csv"
        with open(filename, 'w', newline='') as csvfile:
            csvwriter = csv.writer(csvfile)
            csvwriter.writerow(COL_HEADERS[table])
            csvwriter.writerow([])
            csvwriter.writerows(response)

main()
