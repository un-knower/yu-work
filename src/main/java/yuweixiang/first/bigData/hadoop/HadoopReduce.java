package yuweixiang.first.bigData.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

/**
 * hadoop中的reduce封装类
 *
 * @author yuweixiang
 * @version $ Id: HadoopReduce.java, v 0.1 16/7/27 下午11:38 yuweixiang Exp $
 */
public class HadoopReduce extends MapReduceBase implements Reducer<Text,IntWritable,Text,IntWritable> {

    @Override
    public void reduce(Text text, Iterator<IntWritable> iterator, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
        int maxValue = Integer.MIN_VALUE;
        while (iterator.hasNext()){
            maxValue = Math.max(maxValue,iterator.next().get());
        }
        outputCollector.collect(text,new IntWritable(maxValue));
    }
}
