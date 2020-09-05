package test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MergeSort {
    public static class Map extends Mapper<Object, Text, IntWritable,IntWritable> {
        private static IntWritable data = new IntWritable();
        public void map(Object key,Text value,Context context)
                throws IOException, InterruptedException{
            String text = value.toString();
            data.set(Integer.parseInt(text));
            data.set(Integer.parseInt(text));
            context.write(data,new IntWritable(1));
        }
    }

    public static class Reduce extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{
        private static IntWritable line_num=new IntWritable(1);
        public void reduce(IntWritable key,Iterable<IntWritable> value,Context context)
                throws IOException,InterruptedException{
            for(IntWritable val : value){
                context.write(line_num,key);
                line_num=new IntWritable(line_num.get()+1);
            }
        }
    }
    public static class Partition extends Partitioner<IntWritable,IntWritable>{

        public int getPartition(IntWritable intWritable, IntWritable intWritable2, int i) {
            int maxNumber=65223;
            int bound = maxNumber/i+1;
            int keyNumber=intWritable.get();
            for(int k=0;k<i;k++){
                if(keyNumber<bound*(k+1)&&keyNumber>=bound*i){
                    return k;
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        String[] otherArgs = new String[]{"input","output"};
        if(otherArgs.length!=2){
            System.err.println("Usage:WordCount<in><out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf,"Merge and Sort");
        job.setJarByClass(MergeSort.class);
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);
        job.setPartitionerClass(Partition.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true)?0:1);
    }
}
