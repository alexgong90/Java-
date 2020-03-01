package com.gc.linkedlist;

import com.sun.istack.internal.Nullable;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //create list
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
      /*  singleLinkedList
                .add(hero1)
                .add(hero2)
                .add(hero3)
                .add(hero4);
        singleLinkedList.list();*/

        singleLinkedList
                .addOrderByNo(hero1)
                .addOrderByNo(hero3)
                .addOrderByNo(hero2)
                .addOrderByNo(hero4);
//        test(singleLinkedList);
        list(singleLinkedList.head);
//        singleLinkedListReverse(singleLinkedList);
        System.out.println("---------------------");

        list(reverse(singleLinkedList.head));
        System.out.println("---------------------");
        list(singleLinkedList.head);
    }

    private static HeroNode reverse(HeroNode head) {
        HeroNode lastNode = new HeroNode(0, "x", "x");

        HeroNode cur = head.next;
        lastNode.next = cur;
        if (cur.next == null) {
            return lastNode;
        }
        HeroNode result = reverse(head.next);
        head.next.next.next = head.next;
        head.next.next = null;

        return result;
    }



    private static void list(@Nullable HeroNode head) {
        if (head == null) {
            System.out.println("head is null");
            return;
        }
        HeroNode pointer = head.next;
        if (pointer == null) {
            System.out.println("list is null");
            return;
        }
        while (true) {
            System.out.println(pointer);
            if (pointer.next == null) {
                break;
            }
            pointer = pointer.next;
        }
    }


    /**
     * 单链表翻转
     *
     * @param singleLinkedList
     */
    private static void singleLinkedListReverse(SingleLinkedList singleLinkedList) {
        HeroNode cur = singleLinkedList.head.next;
        if (cur == null) {
            return;
        }

        if (cur.next == null) {
            //reverse has done

        }
        while (true) {
            if (cur.next.next == null) {
                break;
            }
            cur = cur.next;
        }
        //cur.next is last node
        cur.next.next = cur;
        cur.next = null;
        singleLinkedListReverse(singleLinkedList);
    }

    private static void test(SingleLinkedList singleLinkedList) {


//        singleLinkedList.updateNode2(new HeroNode(2,"axx","yyf"));

        singleLinkedList.remove2(new HeroNode(1, "宋江", "及时雨"));


        singleLinkedList.list();
    }

}
