About
----------
Skeleton scala-based project for the boris-bikes exercises - as part of
the Scott Logic **Data Engineering Training course**

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


###### General hints and tips

- Use the sbt shell for quick feedback
- Use your IDE to explore the api
- `df.show` and `df.printSchema` are your friends
- Implement the following methods defined in `RouteAnalysis`
- At the command line run `sbt` followed by `test` to check your results
- Running `~testQuick` will rerun failing tests when a relevant code change
 is detected


#### Exercises


1. firstTenRows
    - Look for an example of reading a file into a DataSet

2. tenMostPopularRoutes
    - The file is a csv - so read it as one!
    - check the api options of a Dataset

3. mostPopularRoutesWithAverageJourneyTime
    - you can use `<column>.cast("int")` in combination with
    `dataset.withColumn` to create a new column cast to the desired type.
    - `import org.apache.spark.sql.functions._` to gain access to useful
    functions for DataFrames.
    - look at the docs for `spark.sql.functions.lit`
