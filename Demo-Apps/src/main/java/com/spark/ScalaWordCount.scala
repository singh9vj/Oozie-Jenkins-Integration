package com.spark

import org.apache.spark.{SparkConf, SparkContext}

object ScalaWordCount {
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count"))
    println("starting word count process ")

    //Reading input file and creating rdd with no of partitions 5
    val bookRDD=sc.textFile("/user/cloudera/examples/input-data/text/data.txt", 4)

    //Regex to clean text
    val pat = """[^\w\s\$]"""
    val cleanBookRDD=bookRDD.map(line=>line.replaceAll(pat, ""))

    val wordsRDD=cleanBookRDD.flatMap(line=>line.split(" "))

    val wordMapRDD=wordsRDD.map(word=>(word->1))

    val wordCountMapRDD=wordMapRDD.reduceByKey(_+_)

    //wordCountMapRDD.saveAsTextFile("/user/cloudera/examples/output-data/sparktext/data.txt")
    wordCountMapRDD.collect().foreach(println)


  }
}
