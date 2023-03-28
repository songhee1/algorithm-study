#include <bits/stdc++.h>
using namespace std;
typedef int element;
typedef struct ListNode
{
    element data;
    struct ListNode *link;
} ListNode;

void error(char *message)
{
    fprintf(stderr, "%s\n", message);
    exit(1);
}

ListNode *insert_first(ListNode *head, int value)
{
    ListNode *p = (ListNode *)malloc(sizeof(ListNode));
    p->data = value;
    p->link = head;
    head = p;
    return head;
}

ListNode *insert(ListNode *head, ListNode *pre, element value)
{
    ListNode *p = (ListNode *)malloc(sizeof(ListNode));
    p->data = value;
    p->link = pre->link;
    pre->link = p;
    return head;
}

ListNode *delete_frist(ListNode *head)
{
    ListNode *removed;
    removed = head;
    head = removed->link;
    free(removed);
    return head;
}

ListNode *deleteone(ListNode *head, ListNode *pre)
{
    ListNode *removed;
    removed = pre->link;
    pre->link = removed->link;
    free(removed);
    return head;
}

void print_list(ListNode *head)
{
    for (ListNode *p = head; p != NULL; p = p->link)
        cout << p->data<<"->" ;
    cout << "NULL \n";
}

int main(void)
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    ListNode *head = NULL;

    for (int i = 0; i < 5; i++)
    {
        head = insert_first(head, i);
        print_list(head);
    }
    for (int i = 0; i < 5; i++)
    {
        head = delete_frist(head);
        print_list(head);
    }
}
