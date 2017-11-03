Boris Bikes: About
------------

The boris-bikes dataset consists of route information from
London’s public bicycle hire scheme (Boris Bikes, Santander Cycles).

Route Analysis
--------------

#### Preliminary tasks
- copy and unzip `2012-journeys.csv.gz` from
`S:\Training\DataEngineering\datasets\boris-bikes` to: `boris-bikes\data`


#### Running a spark job
At the command line type:

    sbt package && spark-submit --class bikes.runner.<classname> target\scala-2.11\boris-bikes_2.11-0.1.jar

Together these commands build the jar and then execute the desired main
 class of that jar - through spark.

#### Completing the tasks

Make the RouteAnalysisTest suite pass!
To run the test suite, use:

```
\> sbt
...
sbt:boris-bikes> test
```

###### General hints and tips

- Use the sbt shell for quick feedback
- Use your IDE to explore the api
- `df.show` and `df.printSchema` are your friends
- Running `~testQuick` will rerun failing tests when a relevant code change
 is detected


#### Exercises


1. firstTenRows
    - Look for an example of reading a file into a DataSet

2. tenMostPopularRoutes
    - The file is a csv - so read it as one!
    - check the api options of a Dataset

3. mostPopularRoutesWithAverageJourneyTime
    - `import org.apache.spark.sql.functions._` to gain access to useful
    functions for DataFrames.
    - look at the docs for `spark.sql.functions.lit`
