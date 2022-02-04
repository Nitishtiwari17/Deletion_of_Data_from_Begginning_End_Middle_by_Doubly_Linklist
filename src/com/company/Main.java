package com.company;

import java.util.Scanner;
public class Main {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void creation() {
        int data, n, m, p;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("enter the data:");
            data = sc.nextInt();
            Node new_node = new Node(data);
            if (head == null) {
                head = new_node;
                tail=new_node;
            }
            else
            {
                System.out.print("enter 1 to insert the item at beginning,2 ti insert the item at the end,3 to insert the item at the middle:");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        new_node.next = head;
                        head.prev=new_node;
                        head = new_node;
                        break;
                    case 2:
                        tail.next=new_node;
                        new_node.prev=tail;
                        tail=new_node;
                        break;
                    case 3:
                        System.out.print("enter position of node to be insert: ");
                        p = sc.nextInt();
                        Node temp1 = head;
                        Node ptr=temp1.next;
                        for (int i = 1; i < (p - 1); i++)
                        {
                            temp1 = ptr;
                            ptr=ptr.next;
                        }
                        new_node.prev = temp1;
                        new_node.next=ptr;
                        temp1.next=new_node;
                        ptr.prev=new_node;
                        break;
                }
            }
            System.out.print("Do u want to add more data.If Yes,press 1:");
            n = sc.nextInt();
        }
        while (n == 1);
    }

    public void delete()
    {
        int data, n, m, p;
        Scanner sc = new Scanner(System.in);
        do {
            if (head == null) {
                System.out.print("LL is empty");
            }
            else
            {
                System.out.print("enter 1 to delete the item from beginning,2 to delete the item from end,3 to delete the item from middle:");
                m = sc.nextInt();
                switch (m) {
                    case 1:
                        Node temp = head;
                        temp = temp.next;
                        head = temp;
                        head.prev=null;
                    case 2:
                        Node temp1 = tail;
                        temp1 = temp1.prev;
                        temp1.next = null;
                        break;
                    case 3:
                        System.out.print("enter the position of node to be deleted:");
                        p = sc.nextInt();
                        Node temp2 = head;
                        Node ptr1 = temp2.next;
                        for (int i = 1; i<(p - 1); i++)
                        {
                            temp2 = ptr1;
                            ptr1 = ptr1.next;
                        }
                        temp2.next = ptr1.next;
                        ptr1.next.prev = temp2;
                        break;
                }
            }
            System.out.print("Do u want to delete more data.If Yes,press 1:");
            n = sc.nextInt();
        }
        while (n == 1);
    }
    public void traverser()
    {
        Node temp = head;
        if (head == null) {
            System.out.print("LL not exist");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args)
    {
        Main L1 = new Main();
        L1.creation();
        L1.delete();
        L1.traverser();

    }
}



