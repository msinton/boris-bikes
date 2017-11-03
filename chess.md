Chess: About
------

The chess dataset consists of about 1 million real games of chess taken
from lichess.org

The data has already been parsed and reformatted into a flattened data
structure - each move is on its own row.

Move Sequences
--------------

#### Preliminary tasks
- copy and unzip `chess.zip` from
`S:\Training\DataEngineering\datasets\chess` to: `boris-bikes\data`

- Note, the cluster has the same chess data saved to `/tmp/chess`

###### General hints and tips

- Use the functions from `performance.Benchmark`

- Remember to clear the cache before executing a task
    when comparing performance (where caching is involved).
    Otherwise caching from a previous run
    invalidates your performance comparison.

#### Exercises

We provide a function `Sequences.percentThatEndInMistake` that looks at
move sequences during a game of chess.

Based on the available data, for a sequence of moves seen,
it calculates the percent of each sequence that terminate in a mistake.

This information could be used, for example, to power a chess AI.


###### Performance:

This function has to do a lot of work.
Additionally, the function executes for only one sequence length at a time.
Therefore, to calculate the results for a number of different
sequence lengths, the function needs to be re-executed a number of times.

1. Create a runner and test the function works for a chosen sequence length,
    when submitted as a Spark job.

2. Run this function with benchmarking for sequences of length 5 to 10,
    both locally and in the cluster. Compare the time taken.
    - Note that on the cluster, the `spark` variable is already present.

3. Improve the performance
    - A well placed `.cache` can do the trick
    - remember to clear the cache for a valid comparison! See General hints.

###### Partitioning:

The following should be completed in a Zeppelin notebook on the cluster.
Here we contrast the result of partitioning data. We look at 2 datasets that
are **almost** exactly the same: (1) `/tmp/chessFlat` and (2) `/tmp/chess`
- (1) and (2) are the same with the exception that (2) has been partitioned by `move`:

        chessDS.repartition($"move").write.parquet("/tmp/chess")

4. Load the data from (1). Call a function on the DataSet
    api to observe the partition size of the underlying rdd.
    Compare this to that of (2)

5. Run the following to observe the physical partitioning that has been
    done. Do the same for `/tmp/chess` also.

         %sh
        hdfs dfs -ls /tmp/chessFlat

6. Run the provided function `chess.MoveAnalysis.allMoveEvalPercents`
    on each version of the data and compare the run times. Look at what
    the function is doing.

7. Think about why there is a difference in performance on the 2 datasets
    and discuss this with your mentor.