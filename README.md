# Team16_Capstone
This is a smartphone app design for personalized cancer symptom management. This application alerts users when it is time for their light therapy sessions, helping them more easily stick to a routine that works for them. Patient light therapy data, which includes therapy frequency and duration, is written from the app to a database that researchers from Michigan State University's College of Nursing can access.

# Program Classes:

## Main Activity

## Database Tool

## Help Activity

## My Info Activity

## Bedtime Questions Activity

## Nap Questions Activity

## Wake Up Questions Activity

## Notification Receiver

## ReEnter Activity

## Reminder Activity

## Repeating Activity

## SetID Activity

## Start Timer Activity

## Thank You Activity

# Data Extraction

## Required Software:

- .csv
- python
- MySQL Workspace
- MySQL Python Connector

## Python script for pulling data from a cloud-based .csv file into MS Excel

The python script "patient_data_getter.py" will be stored in a file location which is convenient to the healthcare provider. As long as the healthcare provider has the required software installed, they can generate Excel files with the necessary patient data. The Excel files will be created in the same file location that the patient_data_getter.py is saved in.

## File format

A seperate Excel file is automatically generated for each database table that exists within the application. For example, a seperate Excel file will be generated for the bedtime questionnaire, the nap time questionnaire, the wake-up questionnaire, and timer usage.
