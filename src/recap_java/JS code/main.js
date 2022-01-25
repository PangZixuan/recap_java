//alert("I'm JavaScript!");
class HashTable {
    constructor(size) {
      this.table = new Array(size);
      this.size = 0;
    }
  
    _hash(key) {
      let hash = 0;
      for (let i = 0; i < key.length; i++) {
        hash += key.charCodeAt(i);
      }
      return hash % this.table.length;
    }
  
    set(key, value) {
      const index = this._hash(key);
      if (this.table[index]) {
        for (let i = 0; i < this.table[index].length; i++) {
          if (this.table[index][i][0] === key) {
            this.table[index][i][1] = value;
            return;
          }
        }
        this.table[index].push([key, value]);
      } else {
        this.table[index] = [];
        this.table[index].push([key, value]);
      }
      this.size++;
    }
  
    get(key) {
      const index = this._hash(key);
      if (this.table[index]) {
        for (let i = 0; i < this.table.length; i++) {
          if (this.table[index][i][0] === key) {
            return this.table[index][i][1];
          }
        }
      }
      return undefined;
    }
  
    remove(key) {
      const index = this._hash(key);
  
      if (this.table[index] && this.table[index].length) {
        for (let i = 0; i < this.table.length; i++) {
          if (this.table[index][i][0] === key) {
            this.table[index].splice(i, 1);
            this.size--;
            return true;
          }
        }
      } else {
        return false;
      }
    }
  
    display() {
      this.table.forEach((values, index) => {
        const chainedValues = values.map(
          ([key, value]) => `[ ${key}: ${value} ]`
        );
        console.log(`${index}: ${chainedValues}`);
      });
    }
}

class Node{
    constructor(data){
        this.data = data;
        this.children =[];
    }
} 
class Tree{

    constructor()
    {
        this.root = null;
    }

    _add(data,toNodeData){
        const node =new Node(data);
        const parent = toNodeData? this.findBFS(toNodeData) : null;
        if(parent){
            parent.children.push(node)
        }else{
            if(!this.root){
                this.root = node;
            }
        }
    }

    _findBFS(data){
        const queue = [this.root];
        let _node=null;

        this.traverseBFS((node) =>{
            if(node.data == data)
                _node=node
        })

        return_node;
    }

    traverseBFS(callBack){
        const queue = [this.root]
        if(cb)
        while(queue.length){
            const node =queue.shift();
            cd(node)
            for(const child of node.children)
            queue.push(child)
        }
    }

}

function hashTest (){
  const ht = new HashTable(20);
  for(let i=0; i <15 ; i++){
    let key = Math.random();
    let value = "value is:" + key.toString;
    ht.set(key,value);
}
ht.display();
}

function treeTest(){
    let tree =new Tree();

    tree._add("node1")
    tree._add("node2","node1")
    tree._add("node3","node1")
    tree._add("node4","node2")

    traverseBFS((node)=>{console.log("current node: ",node)})
}