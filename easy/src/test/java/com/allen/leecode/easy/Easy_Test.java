package com.allen.leecode.easy;

import junit.framework.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>项目名称:leecode </p>
 * <p>Copyright (c) 2015, Inspur GSP All Rights Reserved.</p>
 * <p>修改记录1: 新建文件-15/4/16上午12:56-zhoulun</p>
 */
public class Easy_Test {


    //region Helper
    protected void AreEqual(Object actual, Object expected, String msg) {
        boolean equal = isEqual(actual, expected, msg);

        Assert.assertTrue("Not equal:" + msg + ",expected is " +
                (expected == null ? " null " : expected.toString()) +
                " but actual is " +
                (actual == null ? "null" : actual.toString()), equal);
    }

    protected void AreNotEqual(Object actual, Object expected, String msg) {
        boolean equal = isEqual(actual, expected, msg);
        Assert.assertTrue("They are equal:" + msg + ",expected is " +
                (expected == null ? " null " : expected.toString()) +
                " but actual is " +
                (actual == null ? "null" : actual.toString()), !equal);

    }
    //endregion

    private boolean isEqual(Object actual, Object expected, String msg) {
        boolean equal = false;
        if (actual == null && expected == null) {
            System.out.println(msg + "Warnning:Assert Equal but All are Null!");
            equal = true;
        } else if (actual == null || expected == null) {
            equal = false;
        } else
            equal = actual.equals(expected);
        return equal;
    }

    @Test
    public void testParentheses() {
        System.out.printf("(%d,)%d,[%d,]%d,{%d,}%d,%c,%c\n",
                (int) '(', (int) ')',
                (int) '[', (int) ']',
                (int) '{', (int) '}',
                92, 124);
    }

    @Test
    public void testValidParentheses() {
        ValidParentheses v = new ValidParentheses();
        Assert.assertTrue(v.isValid(null));
        Assert.assertTrue(v.isValid(""));
        Assert.assertFalse(v.isValid("("));
        Assert.assertFalse(v.isValid(")"));
        Assert.assertTrue(v.isValid("()"));
        Assert.assertTrue(v.isValid("()"));
        Assert.assertFalse(v.isValid(")("));
        Assert.assertFalse(v.isValid(")()"));
        Assert.assertTrue(v.isValid("()[]"));
        Assert.assertTrue(v.isValid("()[]{}"));
        Assert.assertTrue(v.isValid("()([]{})"));
        Assert.assertFalse(v.isValid("([)]"));
    }

    @Test
    public void testAscIIInt() {
        System.out.printf("%d,%d,%d", (int) '1', (int) '9', (int) '0');
    }

    @Test
    public void testCountAndSay() {

        Map<Integer, String> result = new HashMap<Integer, String>(8);
        result.put(1, "1");
        result.put(2, "11");
        result.put(3, "21");
        result.put(4, "1211");
        result.put(5, "111221");
        result.put(6, "312211");
        result.put(7, "13112221");
        result.put(8, "1113213211");
        CountAndSay action = new CountAndSay();
        for (Integer integer : result.keySet()) {
            String r = action.countAndSay(integer);
            Assert.assertTrue(integer.toString() + "," + r,
                    r.equals(result.get(integer)));
        }


    }

    @Test
    public void testNumberOfOneBits() {
        Map<Integer, Integer> result = new HashMap<Integer, Integer>(8);
        result.put(1, 1);
        result.put(2, 1);
        result.put(3, 2);
        result.put(-1, 31);
//        result.put(5, "111221");
//        result.put(6, "312211");
//        result.put(7, "13112221");
//        result.put(8, "1113213211");

        NumberOfOneBits actor = new NumberOfOneBits();
        for (Integer integer : result.keySet()) {
            int r = actor.hammingWeight(integer);
            AreEqual(r, result.get(integer), integer.toString() + "," + r);
        }

    }

    @Test
    public void testSwap() {
        System.out.println((int) ((4 - 1) / 2));
        System.out.println((int) ((5 - 1) / 2));
    }

    @Test
    public void testTwoSum() {
        TwoSum actor = new TwoSum();
        int[] array = actor.twoSum(new int[]{2, 7, 11, 15}, 9);
        Assert.assertTrue(array[1] == 1);
        Assert.assertTrue(array[2] == 2);

        array = actor.twoSum(new int[]{-3, 4, 3, 90}, 0);
        Assert.assertTrue(array[1] == 1);
        Assert.assertTrue(array[2] == 3);
    }

    @Test
    public void testAddTwoNumbers() {

        ListNode left = ListNode.build(new int[]{2, 4, 3});
        ListNode right = ListNode.build(new int[]{5, 6, 4});
        ListNode result = ListNode.build(new int[]{7, 0, 8});
        AddTwoNumbers action = new AddTwoNumbers();
        ListNode acutalResult = action.addTwoNumbers(left, right);

        AreEqual(acutalResult,result,"not equal");


        left = ListNode.build(new int[]{9});
        right = ListNode.build(new int[]{9});
        result = ListNode.build(new int[]{8,1});

        acutalResult = action.addTwoNumbers(left, right);

        AreEqual(acutalResult,result,"not equal");
    }
}
