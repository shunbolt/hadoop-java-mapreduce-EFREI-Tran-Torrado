# Document from Tran Raphael and Torrado Yoann 
### TP MapReduce2 JAVA
###
---
###

- [x] 1.8.1 Districts containing trees (very easy)
- [x] 1.8.2 Show all existing species (very easy)
- [x] 1.8.3 Number of trees by species (easy)
- [x] 1.8.4 Maximum height per specie of tree (average)
- [x] 1.8.5 Sort the trees height from smallest to largest (average)
- [ ] 1.8.6 District containing the oldest tree (difficult)
- [ ] 1.8.7 District containing the most trees (very difficult)

###
---
##### Result for first exercice 1.8.1 Districts containing trees (very easy)
###
#####  Log : districtcount command
###
###

    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \districtcount trees.csv result
    20/11/04 16:09:03 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/04 16:09:03 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604502543710, maxDate=1605107343710, sequenceNumber=4171, masterKeyId=39 on ha-hdfs:efrei
    20/11/04 16:09:03 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604502543710, maxDate=1605107343710, sequenceNumber=4171, masterKeyId=39)
    20/11/04 16:09:03 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2018
    20/11/04 16:09:04 INFO input.FileInputFormat: Total input files to process : 1
    20/11/04 16:09:04 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/04 16:09:05 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2018
    20/11/04 16:09:05 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604502543710, maxDate=1605107343710, sequenceNumber=4171, masterKeyId=39)]
    20/11/04 16:09:05 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/04 16:09:05 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/04 16:09:05 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2018
    20/11/04 16:09:05 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2018/
    20/11/04 16:09:05 INFO mapreduce.Job: Running job: job_1603290159664_2018
    20/11/04 16:09:15 INFO mapreduce.Job: Job job_1603290159664_2018 running in uber mode : false
    20/11/04 16:09:15 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/04 16:09:25 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/04 16:09:35 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/04 16:09:35 INFO mapreduce.Job: Job job_1603290159664_2018 completed successfully
    20/11/04 16:09:35 INFO mapreduce.Job: Counters: 53
            File System Counters
                    FILE: Number of bytes read=84
                    FILE: Number of bytes written=493341
                    FILE: Number of read operations=0
                    FILE: Number of large read operations=0
                    FILE: Number of write operations=0
                    HDFS: Number of bytes read=16879
                    HDFS: Number of bytes written=44
                    HDFS: Number of read operations=8
                    HDFS: Number of large read operations=0
                    HDFS: Number of write operations=2
            Job Counters
                    Launched map tasks=1
                    Launched reduce tasks=1
                    Data-local map tasks=1
                    Total time spent by all maps in occupied slots (ms)=21219
                    Total time spent by all reduces in occupied slots (ms)=27296
                    Total time spent by all map tasks (ms)=7073
                    Total time spent by all reduce tasks (ms)=6824
                    Total vcore-milliseconds taken by all map tasks=7073
                    Total vcore-milliseconds taken by all reduce tasks=6824
                    Total megabyte-milliseconds taken by all map tasks=10864128
                    Total megabyte-milliseconds taken by all reduce tasks=13975552
            Map-Reduce Framework
                    Map input records=98
                    Map output records=97
                    Map output bytes=277
                    Map output materialized bytes=84
                    Input split bytes=101
                    Combine input records=97
                    Combine output records=17
                    Reduce input groups=17
                    Reduce shuffle bytes=84
                    Reduce input records=17
                    Reduce output records=17
                    Spilled Records=34
                    Shuffled Maps =1
                    Failed Shuffles=0
                    Merged Map outputs=1
                    GC time elapsed (ms)=183
                    CPU time spent (ms)=3020
                    Physical memory (bytes) snapshot=1450090496
                    Virtual memory (bytes) snapshot=7268896768
                    Total committed heap usage (bytes)=1563426816
                    Peak Map Physical memory (bytes)=1158758400
                    Peak Map Virtual memory (bytes)=3394510848
                    Peak Reduce Physical memory (bytes)=291332096
                    Peak Reduce Virtual memory (bytes)=3874385920
            Shuffle Errors
                    BAD_ID=0
                    CONNECTION=0
                    IO_ERROR=0
                    WRONG_LENGTH=0
                    WRONG_MAP=0
                    WRONG_REDUCE=0
            File Input Format Counters
                    Bytes Read=16778
            File Output Format Counters
                    Bytes Written=44
                
#####  Log : districtcount result
###            
###
                
    -bash-4.2$ hdfs dfs -cat result/part-r-00000
    11
    12
    13
    14
    15
    16
    17
    18
    19
    20
    3
    4
    5
    6
    7
    8
    9
###
---
##### Result for second exercice 1.8.2 Show all existing species (very easy)
###
#####  Log : speciescount command
###
###

    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \speciescount trees.csv result1
    20/11/04 16:29:43 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/04 16:29:43 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604503783420, maxDate=1605108583420, sequenceNumber=4178, masterKeyId=39 on ha-hdfs:efrei
    20/11/04 16:29:43 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604503783420, maxDate=1605108583420, sequenceNumber=4178, masterKeyId=39)
    20/11/04 16:29:43 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2025
    20/11/04 16:29:44 INFO input.FileInputFormat: Total input files to process : 1
    20/11/04 16:29:44 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/04 16:29:44 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2025
    20/11/04 16:29:44 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604503783420, maxDate=1605108583420, sequenceNumber=4178, masterKeyId=39)]
    20/11/04 16:29:44 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/04 16:29:44 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/04 16:29:45 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2025
    20/11/04 16:29:45 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2025/
    20/11/04 16:29:45 INFO mapreduce.Job: Running job: job_1603290159664_2025
    20/11/04 16:29:55 INFO mapreduce.Job: Job job_1603290159664_2025 running in uber mode : false
    20/11/04 16:29:55 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/04 16:30:04 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/04 16:30:10 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/04 16:30:10 INFO mapreduce.Job: Job job_1603290159664_2025 completed successfully
    20/11/04 16:30:10 INFO mapreduce.Job: Counters: 53
            File System Counters
                    FILE: Number of bytes read=547
                    FILE: Number of bytes written=494261
                    FILE: Number of read operations=0
                    FILE: Number of large read operations=0
                    FILE: Number of write operations=0
                    HDFS: Number of bytes read=16879
                    HDFS: Number of bytes written=451
                    HDFS: Number of read operations=8
                    HDFS: Number of large read operations=0
                    HDFS: Number of write operations=2
            Job Counters
                    Launched map tasks=1
                    Launched reduce tasks=1
                    Data-local map tasks=1
                    Total time spent by all maps in occupied slots (ms)=21810
                    Total time spent by all reduces in occupied slots (ms)=11932
                    Total time spent by all map tasks (ms)=7270
                    Total time spent by all reduce tasks (ms)=2983
                    Total vcore-milliseconds taken by all map tasks=7270
                    Total vcore-milliseconds taken by all reduce tasks=2983
                    Total megabyte-milliseconds taken by all map tasks=11166720
                    Total megabyte-milliseconds taken by all reduce tasks=6109184
            Map-Reduce Framework
                    Map input records=98
                    Map output records=97
                    Map output bytes=995
                    Map output materialized bytes=547
                    Input split bytes=101
                    Combine input records=97
                    Combine output records=45
                    Reduce input groups=45
                    Reduce shuffle bytes=547
                    Reduce input records=45
                    Reduce output records=45
                    Spilled Records=90
                    Shuffled Maps =1
                    Failed Shuffles=0
                    Merged Map outputs=1
                    GC time elapsed (ms)=221
                    CPU time spent (ms)=4040
                    Physical memory (bytes) snapshot=1459535872
                    Virtual memory (bytes) snapshot=7275765760
                    Total committed heap usage (bytes)=1549795328
                    Peak Map Physical memory (bytes)=1158606848
                    Peak Map Virtual memory (bytes)=3399340032
                    Peak Reduce Physical memory (bytes)=300929024
                    Peak Reduce Virtual memory (bytes)=3876425728
            Shuffle Errors
                    BAD_ID=0
                    CONNECTION=0
                    IO_ERROR=0
                    WRONG_LENGTH=0
                    WRONG_MAP=0
                    WRONG_REDUCE=0
            File Input Format Counters
                    Bytes Read=16778
            File Output Format Counters
                    Bytes Written=451
                

#####  Log : speciescount result
###
###
    -bash-4.2$ hdfs dfs -cat result1/part-r-00000
    araucana
    atlantica
    australis
    baccata
    bignonioides
    biloba
    bungeana
    cappadocicum
    carpinifolia
    colurna
    coulteri
    decurrens
    dioicus
    distichum
    excelsior
    fraxinifolia
    giganteum
    giraldii
    glutinosa
    grandiflora
    hippocastanum
    ilex
    involucrata
    japonicum
    kaki
    libanii
    monspessulanum
    nigra
    nigra laricio
    opalus
    orientalis
    papyrifera
    petraea
    pomifera
    pseudoacacia
    sempervirens
    serrata
    stenoptera
    suber
    sylvatica
    tomentosa
    tulipifera
    ulmoides
    virginiana
    x acerifolia


###
---
##### Result for third exercice 1.8.3 Number of trees by species (easy)
###
#####  Log : speciescountwithtrees command
###
###

    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \speciescountwithtrees trees.csv result2
    20/11/04 16:34:36 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/04 16:34:36 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604504076357, maxDate=1605108876357, sequenceNumber=4184, masterKeyId=39 on ha-hdfs:efrei
    20/11/04 16:34:36 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604504076357, maxDate=1605108876357, sequenceNumber=4184, masterKeyId=39)
    20/11/04 16:34:36 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2031
    20/11/04 16:34:37 INFO input.FileInputFormat: Total input files to process : 1
    20/11/04 16:34:37 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/04 16:34:37 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2031
    20/11/04 16:34:37 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604504076357, maxDate=1605108876357, sequenceNumber=4184, masterKeyId=39)]
    20/11/04 16:34:37 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/04 16:34:37 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/04 16:34:38 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2031
    20/11/04 16:34:38 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2031/
    20/11/04 16:34:38 INFO mapreduce.Job: Running job: job_1603290159664_2031
    20/11/04 16:34:48 INFO mapreduce.Job: Job job_1603290159664_2031 running in uber mode : false
    20/11/04 16:34:48 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/04 16:34:58 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/04 16:35:08 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/04 16:35:08 INFO mapreduce.Job: Job job_1603290159664_2031 completed successfully
    20/11/04 16:35:09 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=727
                FILE: Number of bytes written=494691
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16879
                HDFS: Number of bytes written=542
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=22986
                Total time spent by all reduces in occupied slots (ms)=29392
                Total time spent by all map tasks (ms)=7662
                Total time spent by all reduce tasks (ms)=7348
                Total vcore-milliseconds taken by all map tasks=7662
                Total vcore-milliseconds taken by all reduce tasks=7348
                Total megabyte-milliseconds taken by all map tasks=11768832
                Total megabyte-milliseconds taken by all reduce tasks=15048704
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=1383
                Map output materialized bytes=727
                Input split bytes=101
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=727
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=194
                CPU time spent (ms)=3320
                Physical memory (bytes) snapshot=1455235072
                Virtual memory (bytes) snapshot=7273242624
                Total committed heap usage (bytes)=1553989632
                Peak Map Physical memory (bytes)=1161678848
                Peak Map Virtual memory (bytes)=3396640768
                Peak Reduce Physical memory (bytes)=293556224
                Peak Reduce Virtual memory (bytes)=3876601856
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=16778
        File Output Format Counters
                Bytes Written=542
                

#####  Log : speciescountwithtrees result
###   
###
    -bash-4.2$ hdfs dfs -cat result2/part-r-00000
    araucana        1
    atlantica       2
    australis       1
    baccata 2
    bignonioides    1
    biloba  5
    bungeana        1
    cappadocicum    1
    carpinifolia    4
    colurna 3
    coulteri        1
    decurrens       1
    dioicus 1
    distichum       3
    excelsior       1
    fraxinifolia    2
    giganteum       5
    giraldii        1
    glutinosa       1
    grandiflora     1
    hippocastanum   3
    ilex    1
    involucrata     1
    japonicum       1
    kaki    2
    libanii 2
    monspessulanum  1
    nigra   3
    nigra laricio   1
    opalus  1
    orientalis      8
    papyrifera      1
    petraea 2
    pomifera        1
    pseudoacacia    1
    sempervirens    1
    serrata 1
    stenoptera      1
    suber   1
    sylvatica       8
    tomentosa       2
    tulipifera      2
    ulmoides        1
    virginiana      2
    x acerifolia    11

###
---
##### Result for fourth exercice 1.8.4 Maximum height per specie of tree (average)
###
#####  Log : speciesheight command
###
###

    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \speciesheight trees.csv result5
    20/11/05 10:15:34 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/05 10:15:34 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604567734243, maxDate=1605172534243, sequenceNumber=4300, masterKeyId=40 on ha-hdfs:efrei
    20/11/05 10:15:34 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604567734243, maxDate=1605172534243, sequenceNumber=4300, masterKeyId=40)
    20/11/05 10:15:34 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2132
    20/11/05 10:15:35 INFO input.FileInputFormat: Total input files to process : 1
    20/11/05 10:15:35 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/05 10:15:35 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2132
    20/11/05 10:15:35 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604567734243, maxDate=1605172534243, sequenceNumber=4300, masterKeyId=40)]
    20/11/05 10:15:35 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/05 10:15:35 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/05 10:15:36 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2132
    20/11/05 10:15:36 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2132/
    20/11/05 10:15:36 INFO mapreduce.Job: Running job: job_1603290159664_2132
    20/11/05 10:15:47 INFO mapreduce.Job: Job job_1603290159664_2132 running in uber mode : false
    20/11/05 10:15:47 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/05 10:15:56 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/05 10:16:01 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/05 10:16:02 INFO mapreduce.Job: Job job_1603290159664_2132 completed successfully
    20/11/05 10:16:02 INFO mapreduce.Job: Counters: 53
        File System Counters
                FILE: Number of bytes read=727
                FILE: Number of bytes written=494667
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=16879
                HDFS: Number of bytes written=675
                HDFS: Number of read operations=8
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=2
        Job Counters
                Launched map tasks=1
                Launched reduce tasks=1
                Data-local map tasks=1
                Total time spent by all maps in occupied slots (ms)=21885
                Total time spent by all reduces in occupied slots (ms)=11848
                Total time spent by all map tasks (ms)=7295
                Total time spent by all reduce tasks (ms)=2962
                Total vcore-milliseconds taken by all map tasks=7295
                Total vcore-milliseconds taken by all reduce tasks=2962
                Total megabyte-milliseconds taken by all map tasks=11205120
                Total megabyte-milliseconds taken by all reduce tasks=6066176
        Map-Reduce Framework
                Map input records=98
                Map output records=97
                Map output bytes=1383
                Map output materialized bytes=727
                Input split bytes=101
                Combine input records=97
                Combine output records=45
                Reduce input groups=45
                Reduce shuffle bytes=727
                Reduce input records=45
                Reduce output records=45
                Spilled Records=90
                Shuffled Maps =1
                Failed Shuffles=0
                Merged Map outputs=1
                GC time elapsed (ms)=180
                CPU time spent (ms)=3210
                Physical memory (bytes) snapshot=1450561536
                Virtual memory (bytes) snapshot=7270592512
                Total committed heap usage (bytes)=1562902528
                Peak Map Physical memory (bytes)=1154424832
                Peak Map Virtual memory (bytes)=3394170880
                Peak Reduce Physical memory (bytes)=296136704
                Peak Reduce Virtual memory (bytes)=3876421632
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters
                Bytes Read=16778
        File Output Format Counters
                Bytes Written=675
                
#####  Log : speciesheight result
###
###

    -bash-4.2$ hdfs dfs -cat result5/part-r-00000
    araucana        9.0
    atlantica       25.0
    australis       16.0
    baccata 13.0
    bignonioides    15.0
    biloba  33.0
    bungeana        10.0
    cappadocicum    16.0
    carpinifolia    30.0
    colurna 20.0
    coulteri        14.0
    decurrens       20.0
    dioicus 10.0
    distichum       35.0
    excelsior       30.0
    fraxinifolia    27.0
    giganteum       35.0
    giraldii        35.0
    glutinosa       16.0
    grandiflora     12.0
    hippocastanum   30.0
    ilex    15.0
    involucrata     12.0
    japonicum       10.0
    kaki    14.0
    libanii 30.0
    monspessulanum  12.0
    nigra   30.0
    nigra laricio   30.0
    opalus  15.0
    orientalis      34.0
    papyrifera      12.0
    petraea 31.0
    pomifera        13.0
    pseudoacacia    11.0
    sempervirens    30.0
    serrata 18.0
    stenoptera      30.0
    suber   10.0
    sylvatica       30.0
    tomentosa       20.0
    tulipifera      35.0
    ulmoides        12.0
    virginiana      14.0
    x acerifolia    45.0

###
---
##### Result for fifth exercice 1.8.5 Sort the trees height from smallest to largest (average)
###
#####  Log : treesheightsort command
###
###

    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \treesheightsort trees.csv result7
    20/11/05 14:33:47 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/05 14:33:47 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604583227646, maxDate=1605188027646, sequenceNumber=4343, masterKeyId=40 on ha-hdfs:efrei
    20/11/05 14:33:47 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604583227646, maxDate=1605188027646, sequenceNumber=4343, masterKeyId=40)
    20/11/05 14:33:47 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2169
    20/11/05 14:33:48 INFO input.FileInputFormat: Total input files to process : 1
    20/11/05 14:33:48 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/05 14:33:49 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2169
    20/11/05 14:33:49 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604583227646, maxDate=1605188027646, sequenceNumber=4343, masterKeyId=40)]
    20/11/05 14:33:49 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/05 14:33:49 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/05 14:33:49 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2169
    20/11/05 14:33:49 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2169/
    20/11/05 14:33:49 INFO mapreduce.Job: Running job: job_1603290159664_2169
    20/11/05 14:33:59 INFO mapreduce.Job: Job job_1603290159664_2169 running in uber mode : false
    20/11/05 14:33:59 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/05 14:34:10 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/05 14:34:19 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/05 14:34:20 INFO mapreduce.Job: Job job_1603290159664_2169 completed successfully
    20/11/05 14:34:20 INFO mapreduce.Job: Counters: 53
            File System Counters
                    FILE: Number of bytes read=3666
                    FILE: Number of bytes written=501323
                    FILE: Number of read operations=0
                    FILE: Number of large read operations=0
                    FILE: Number of write operations=0
                    HDFS: Number of bytes read=16879
                    HDFS: Number of bytes written=3559
                    HDFS: Number of read operations=8
                    HDFS: Number of large read operations=0
                    HDFS: Number of write operations=2
            Job Counters
                    Launched map tasks=1
                    Launched reduce tasks=1
                    Data-local map tasks=1
                    Total time spent by all maps in occupied slots (ms)=21471
                    Total time spent by all reduces in occupied slots (ms)=28704
                    Total time spent by all map tasks (ms)=7157
                    Total time spent by all reduce tasks (ms)=7176
                    Total vcore-milliseconds taken by all map tasks=7157
                    Total vcore-milliseconds taken by all reduce tasks=7176
                    Total megabyte-milliseconds taken by all map tasks=10993152
                    Total megabyte-milliseconds taken by all reduce tasks=14696448
            Map-Reduce Framework
                    Map input records=98
                    Map output records=97
                    Map output bytes=3466
                    Map output materialized bytes=3666
                    Input split bytes=101
                    Combine input records=0
                    Combine output records=0
                    Reduce input groups=97
                    Reduce shuffle bytes=3666
                    Reduce input records=97
                    Reduce output records=97
                    Spilled Records=194
                    Shuffled Maps =1
                    Failed Shuffles=0
                    Merged Map outputs=1
                    GC time elapsed (ms)=175
                    CPU time spent (ms)=3400
                    Physical memory (bytes) snapshot=1450717184
                    Virtual memory (bytes) snapshot=7268962304
                    Total committed heap usage (bytes)=1558708224
                    Peak Map Physical memory (bytes)=1158463488
                    Peak Map Virtual memory (bytes)=3395170304
                    Peak Reduce Physical memory (bytes)=292253696
                    Peak Reduce Virtual memory (bytes)=3873792000
            Shuffle Errors
                    BAD_ID=0
                    CONNECTION=0
                    IO_ERROR=0
                    WRONG_LENGTH=0
                    WRONG_MAP=0
                    WRONG_REDUCE=0
            File Input Format Counters
                    Bytes Read=16778
            File Output Format Counters
                    Bytes Written=3559
                    
#####  Log : treesheightsort result
###
###                    
    -bash-4.2$ hdfs dfs -cat result7/part-r-00000
    (48.8453050031, 2.35307565328) 2.00
    (48.8320684332, 2.41182825531) 5.00
    (48.867221687, 2.27027693483) 6.00
    (48.8716117578, 2.24933653506) 9.00
    (48.8213214388, 2.45537251962) 10.00
    (48.8471789821, 2.25293802515) 10.00
    (48.8615768444, 2.25902702441) 10.00
    (48.8691485018, 2.27224125103) 10.00
    (48.8814628758, 2.38367383179) 10.00
    (48.8520958913, 2.34740754195) 11.00
    (48.8215800145, 2.45494779675) 12.00
    (48.8232165418, 2.46016871078) 12.00
    (48.8314334738, 2.4115101993) 12.00
    (48.8450859307, 2.26948936839) 12.00
    (48.8578717375, 2.29706549763) 12.00
    (48.8588189763, 2.25832952119) 12.00
    (48.8619346483, 2.39870061217) 12.00
    (48.8732545226, 2.24886543775) 12.00
    (48.857140829, 2.29533455314) 13.00
    (48.8708601366, 2.24769299518) 13.00
    (48.8210086122, 2.45551492936) 14.00
    (48.8400754064, 2.43381509843) 14.00
    (48.8647824278, 2.25120424857) 14.00
    (48.8183933679, 2.43791766754) 15.00
    (48.8302532096, 2.41400587444) 15.00
    (48.8557581795, 2.35399582218) 15.00
    (48.856902513, 2.33666989768) 15.00
    (48.8731203887, 2.24884917245) 15.00
    (48.8373323894, 2.40776275516) 16.00
    (48.8400020891, 2.46422657197) 16.00
    (48.8428118006, 2.2972574926) 16.00
    (48.86260617, 2.23782412563) 16.00
    (48.8330496955, 2.35078878768) 18.00
    (48.8347628794, 2.42029690936) 18.00
    (48.8622517606, 2.26098883991) 18.00
    (48.8640166469, 2.26774597209) 18.00
    (48.8324049718, 2.41169855654) 20.00
    (48.8399672948, 2.43375148978) 20.00
    (48.85646631, 2.39469777758) 20.00
    (48.8577766649, 2.29329076205) 20.00
    (48.861574817, 2.2910717819) 20.00
    (48.8618464812, 2.37910176561) 20.00
    (48.8619170093, 2.2924448277) 20.00
    (48.8648376291, 2.36062929978) 20.00
    (48.8652536076, 2.31333976248) 20.00
    (48.8669690843, 2.31951408752) 20.00
    (48.8685686134, 2.31331809304) 20.00
    (48.8830346813, 2.37007425143) 20.00
    (48.8319232533, 2.41202933239) 22.00
    (48.833545551, 2.41033694606) 22.00
    (48.8597396934, 2.39997847741) 22.00
    (48.8768191638, 2.33210374339) 22.00
    (48.8792159582, 2.30640768208) 22.00
    (48.8420426954, 2.43848438671) 23.00
    (48.8204495642, 2.44579219199) 25.00
    (48.827737189, 2.3592096955) 25.00
    (48.8292071873, 2.41301158121) 25.00
    (48.8336849895, 2.42111102704) 25.00
    (48.8476260928, 2.25278179131) 25.00
    (48.8661956075, 2.26238964912) 25.00
    (48.8704017043, 2.24852577475) 26.00
    (48.8633555664, 2.26174532022) 27.00
    (48.8646024472, 2.25171449183) 27.00
    (48.8845880534, 2.34391859224) 27.00
    (48.8333849101, 2.41261756721) 28.00
    (48.8201249835, 2.44524393613) 30.00
    (48.8220238534, 2.33628540112) 30.00
    (48.8224956954, 2.3366608746) 30.00
    (48.8341842636, 2.46130493573) 30.00
    (48.8471653404, 2.25199572129) 30.00
    (48.8630909172, 2.24159242682) 30.00
    (48.8632834941, 2.24066981564) 30.00
    (48.8634848878, 2.2403752961) 30.00
    (48.8646850734, 2.25360607406) 30.00
    (48.865022534, 2.2538285063) 30.00
    (48.8693939056, 2.24776773334) 30.00
    (48.8717782491, 2.27973325759) 30.00
    (48.8723867386, 2.27912885453) 30.00
    (48.8727584235, 2.2873548507) 30.00
    (48.8764503804, 2.25765244347) 30.00
    (48.8820015094, 2.39836942721) 30.00
    (48.8880577555, 2.31595908796) 30.00
    (48.8433252639, 2.4497117757) 31.00
    (48.8785456147, 2.30757576047) 31.00
    (48.8395160905, 2.43350820893) 32.00
    (48.8802898189, 2.38157469859) 33.00
    (48.8803986732, 2.38129958306) 34.00
    (48.8353848188, 2.38157245444) 35.00
    (48.8394165343, 2.43360205128) 35.00
    (48.846044762, 2.2529555706) 35.00
    (48.8606198209, 2.2599223737) 35.00
    (48.879759998, 2.38064802989) 35.00
    (48.8226749117, 2.33869560229) 40.00
    (48.867043584, 2.25320074406) 40.00
    (48.8691433358, 2.24587597613) 40.00
    (48.8323806372, 2.41052012477) 42.00
    (48.8325900983, 2.41116455985) 45.00

###
---
##### Result for sixth exercice 1.8.6 District containing the oldest tree (difficult)
###
#####  Log : districtoldest command
###
###
    -bash-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar \districtoldest trees.csv result9
    20/11/05 17:45:37 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
    20/11/05 17:45:38 INFO hdfs.DFSClient: Created token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604594738111, maxDate=1605199538111, sequenceNumber=4382, masterKeyId=40 on ha-hdfs:efrei
    20/11/05 17:45:38 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604594738111, maxDate=1605199538111, sequenceNumber=4382, masterKeyId=40)
    20/11/05 17:45:38 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/ytorrado/.staging/job_1603290159664_2202
    20/11/05 17:45:39 INFO input.FileInputFormat: Total input files to process : 1
    20/11/05 17:45:39 INFO mapreduce.JobSubmitter: number of splits:1
    20/11/05 17:45:39 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_2202
    20/11/05 17:45:39 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for ytorrado: HDFS_DELEGATION_TOKEN owner=ytorrado@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1604594738111, maxDate=1605199538111, sequenceNumber=4382, masterKeyId=40)]
    20/11/05 17:45:39 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
    20/11/05 17:45:39 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
    20/11/05 17:45:40 INFO impl.YarnClientImpl: Submitted application application_1603290159664_2202
    20/11/05 17:45:40 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_2202/
    20/11/05 17:45:40 INFO mapreduce.Job: Running job: job_1603290159664_2202
    20/11/05 17:45:51 INFO mapreduce.Job: Job job_1603290159664_2202 running in uber mode : false
    20/11/05 17:45:51 INFO mapreduce.Job:  map 0% reduce 0%
    20/11/05 17:46:00 INFO mapreduce.Job:  map 100% reduce 0%
    20/11/05 17:46:10 INFO mapreduce.Job:  map 100% reduce 100%
    20/11/05 17:46:10 INFO mapreduce.Job: Job job_1603290159664_2202 completed successfully
    20/11/05 17:46:10 INFO mapreduce.Job: Counters: 53
            File System Counters
                    FILE: Number of bytes read=10
                    FILE: Number of bytes written=494403
                    FILE: Number of read operations=0
                    FILE: Number of large read operations=0
                    FILE: Number of write operations=0
                    HDFS: Number of bytes read=16879
                    HDFS: Number of bytes written=2
                    HDFS: Number of read operations=8
                    HDFS: Number of large read operations=0
                    HDFS: Number of write operations=2
            Job Counters
                    Launched map tasks=1
                    Launched reduce tasks=1
                    Data-local map tasks=1
                    Total time spent by all maps in occupied slots (ms)=21072
                    Total time spent by all reduces in occupied slots (ms)=28356
                    Total time spent by all map tasks (ms)=7024
                    Total time spent by all reduce tasks (ms)=7089
                    Total vcore-milliseconds taken by all map tasks=7024
                    Total vcore-milliseconds taken by all reduce tasks=7089
                    Total megabyte-milliseconds taken by all map tasks=10788864
                    Total megabyte-milliseconds taken by all reduce tasks=14518272
            Map-Reduce Framework
                    Map input records=98
                    Map output records=1
                    Map output bytes=2
                    Map output materialized bytes=10
                    Input split bytes=101
                    Combine input records=1
                    Combine output records=1
                    Reduce input groups=1
                    Reduce shuffle bytes=10
                    Reduce input records=1
                    Reduce output records=1
                    Spilled Records=2
                    Shuffled Maps =1
                    Failed Shuffles=0
                    Merged Map outputs=1
                    GC time elapsed (ms)=160
                    CPU time spent (ms)=2990
                    Physical memory (bytes) snapshot=1461493760
                    Virtual memory (bytes) snapshot=7271616512
                    Total committed heap usage (bytes)=1557135360
                    Peak Map Physical memory (bytes)=1161154560
                    Peak Map Virtual memory (bytes)=3397066752
                    Peak Reduce Physical memory (bytes)=300339200
                    Peak Reduce Virtual memory (bytes)=3874549760
            Shuffle Errors
                    BAD_ID=0
                    CONNECTION=0
                    IO_ERROR=0
                    WRONG_LENGTH=0
                    WRONG_MAP=0
                    WRONG_REDUCE=0
            File Input Format Counters
                    Bytes Read=16778
            File Output Format Counters
                    Bytes Written=2

#####  Log : districtoldest result
###
###
    -bash-4.2$ hdfs dfs -cat result9/part-r-00000
    5

