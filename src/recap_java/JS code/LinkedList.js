
class Node
{
    data = 0;
    next = null;
    constructor(data)
    {
        this.data = data;
    }
}
class LinkedList
{
    head = null;
    data = 0;
    
    append(data)
    {
        var new_node = new this.#Node(data);
        if (this.head == null)
        {
            this.head = new_node;
        }
         else {
            var last = this.head;
            while (last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
        }
    }
    prepend(data)
    {
        var new_head = new this.#Node(data);
        new_head.next = this.head;
        this.head = new_head;
    }
    get(index)
    {
        var current_index = 0;
        var current = this.head;
        while (current_index < index)
        {
            if (current.next != null)
            {
                current = current.next;
            }
             else {
                return null;
            }
            current_index += 1;
        }
        return current.data;
    }
    deleteValue(data)
    {
        if (this.head == null)
        {
            return;
        }
        if (this.head.data == data)
        {
            this.head = this.head.next;
            return;
        }
        var current = this.head;
        while (current.next != null)
        {
            if (current.next.data == data)
            {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
