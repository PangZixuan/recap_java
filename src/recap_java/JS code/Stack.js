 class Stack {
    
     constractor(size){
        let top;
        let stack=[];
        let index = -1;
        stack = new Object[size];
        top = null;
    }
    isEmpty(){
        return (top == null);
    }
    push(item){
        top = item;
        index ++;
        stack[index] = top;
    }
    pop(){
        let value= top;
        index--;
        if(index < 0){
            top = null;
        }else{
        top = stack[index];
        }
        return  value;
    }
    peek(){
        return top;
    }
    print(){
        let cursor = index ;
        while(cursor >= 0){
            console.log(stack[cursor]);
            cursor--;
        }
       
    }
 }
function stackTest(){
  stack = new Stack(20);
	for(let i=0; i <15 ; i++){
		let value = random.nextInt(0,100);
        stack.push(value);
        System.out.println("add value: "+ value);
    }
    stack.print();
    stack.pop();
        console.log(stack.isEmpty());
    for(let i=0; i <14 ; i++){
		stack.pop();
    }
    console.log(stack.isEmpty());

}