package com.djcao.sell.algorithm.review1;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/6
 * 时间复杂度：O(nlogn)
 * 空间复杂度:O(logn)
 */
public class QuickSort extends AbstractSort {
    @Override
    public AbstractSort sort() {
        recurse(0, value.length-1);
        return this;
    }

    public void recurse(int first,int last){
        if (first >= last) return;
        if (first < 0 || last >= value.length)
            throw new IndexOutOfBoundsException();
        int startValue = value[first];
        int left = first,right = last;
        while (left < right){
            while (left < right && value[right] >= startValue)
                right--;
            while (left < right && value[left] <= startValue)
                left++;
            if (left != right)
                swap(left,right);
        }
        if (first != left)
            swap(first,left);
        recurse(first,right-1);
        recurse(right+1,last);
    }

    public static void main(String[] args) {
        AbstractSort abstractSort = new QuickSort();
        if (abstractSort.sort().isSort())
            System.out.println(abstractSort.printValue());

        String string_rule = "{\n" +
            "  \"report_info\": {\n" +
            "    \"task_id\": \"{{$.tid}}\",\n" +
            "    \"status\": \"^(INVALID|WAIT_DATA|ACCEPT|RUNNING|COMPLETE|FAILURE|PROCESS)$\"\n" +
            "  },\n" +
            "  \"task_info\": {\n" +
            "    \"error_message\": \"^\\\\S{0,30}$\",\n" +
            "    \"progress_message\": \"^\\\\S{0,30}$\",\n" +
            "    \"open_id\": \"{{$.openID}}\",\n" +
            "    \"organization_id\": \"{{$.orgID}}\",\n" +
            "    \"next_action\": \"^(CONTINUE|WAIT|FAILURE|COMPLETE)$\",\n" +
            "    \"organization_type\": \"{{$.orgType}}\",\n" +
            "    \"progress\": \"^(1|0\\\\.\\\\d{1})$\",\n" +
            "    \"error_code\": \"^(0|-1|'\"\"')$\",\n" +
            "    \"task_id\": \"{{$.tid}}\",\n" +
            "    \"status\": \"^(INVALID|ACCEPT|WAIT|PROGRESS_ACCEPT|LOGINNING|FAILURE|CRAWLING|INTERACTEND|EXTRACTING|COMPLETE)$\"\n" +
            "  },\n" +
            "  \"return_code\": \"0\"\n" +
            "}";
    }
}
