class Graph{
    #nodes;
    constructor(){
    this.#nodes ={}
    }

    addNode(node){
        this.#nodes[node] = [];
    }

    addEdge(source,destination){
        if(!this.#nodes[source] || !this.#nodes[destination]){
            return false;
        }
        if(!this.#nodes[source].includes(destination)){
            this.#nodes[destination].push(source)
        }
    }

    printGraph(){
        console.log(this.#nodes);
    }

    bfs(source,destination){
        const queue = [source];
        const visited = {};
        while(queue.length){
            let current = queue.shift();
            if(visited[current]){
                continue;
            }
            if(current == destination){
                return true;
            }

            visited[current] = true;
            let neighbor = this.#nodes[current];
            for(let i = 0; i<neighbor.length; i++){
                queue.push[neighbor[i]];
            }


        }
    }

}