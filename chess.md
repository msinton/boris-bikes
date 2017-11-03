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

###### General hints and tips

- Use the functions from `performance.Benchmark`

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

- Note, the cluster has the same chess data saved to `/tmp/chess`

1. Create a runner and test the function works for a chosen sequence length,
    when submitted as a Spark job.

2. Run this function with benchmarking for sequences of length 5 to 10,
    both locally and in the cluster. Compare the time taken.
    - On the cluster the `spark` variable is already present.

3. Improve the performance
    - A well placed `.cache` can do the trick

###### Partitioning:

The following should be completed in a Zeppelin notebook on the cluster.
Here we contrast the result of partitioning data. We look at 2 datasets that
are **almost** exactly the same: (1) `/tmp/chessFlat` and (2) `/tmp/chess`
- (1) and (2) are the same with the exception that (2) has been partitioned by `move`:

        chessDS.repartition($"move").write.parquet("/tmp/chess")

4. Load the data from `/tmp/chessFlat`. This is the same data as in
    `/tmp/chess`. Call a function to observe the partition size of the
    underlying rdd. Compare this to that of `/tmp/chess`

5. Run the following to observe the physical partitioning that has been
    done. Do the same for `/tmp/chess` also.

         %sh
        hdfs dfs -ls /tmp/chessFlat

6.