# PPC-SPINE-Candidate-Assignment
Publicis Media – Candidate Assignment for Data Engineer/Martin Uria

Set up Instructions: 
1.	Unpack the tar.gz file and find the README.md for instructions on the problem
2.	The input files are located in the src/main/resources folder.
3.	Java/Scala interfaces are available in the src/main/java and src/main/scala folders

Here are the contents of the README.md:
==============
# Show Top URLs

## Code Challenge

Given:
* Multiple text input files
* Each file contains multiple lines
* Each line contains 3 comma separated fields: `url,impression_count,timestamp` 

Assume:
* `url` is a String 
* `impression_count` is an integer 
* `timestamp` is an integer representing unix timestamp
* `url` and `timestamp` are non unique
* All lines are formatted correctly, input validation is not required

## Instructions

***Write a program (preferably in Java or Scala) that:***

- Accept list of input files as command line arguments
- (Optional) Read input files concurrently
- Calculate `impression_count` for each URL
- Display top 100 unique URLs with highest impression count
- Display 100 oldest unique URLs (lowest `timestamp`)

**Notes**

- A sample interface ([UrlAnalyzer](src/main/java/com/publicismedia/topurls/UrlAnalyzer.java)) has been provided, using it is optional
- A sample implementations have also been provided ([UrlAnalyzerImpl](src/main/java/com/publicismedia/topurls/UrlAnalyzerImpl.java), [UrlAnalyzerImpl2](src/main/scala/com/publicismedia/topurls/UrlAnalyzerImpl2.scala))) 
- Do not use `Collections.sort()` or `scala.util.Sorting.quickSort()` or similar list sorting methods in your implementation
- Writing tests is required; a sample test ([AppSpec](src/test/scala/com/publicismedia/topurls/AppSpec.scala)) has been provided, using it is optional
- Use a build tool (SBT, Maven, Gradle, Ant, etc) 

**Evaluation Criteria**

* (5 points) Functionality - Do the tests pass? Does it produce the correct output?
* (5 points) Data Structures - What data structures are used? Are the choices sensible? 
* (5 points) Code Quality - Is it clear what the code does? Is the project well organized? Are there comments?
* (5 points) Tests - Are there tests? How well do they test the code and validate output?
