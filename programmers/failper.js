function solution(N, stages) {
    var answer = [];
    var result = [];
    var temp;
    var mole = 0;
    var done = stages.length;
    for(var i = 0 ; i < N ; i++, mole = 0)
    {
        for(var j = 0 ; j < stages.length; j++)
        {
            if(i+1 == stages[j])
                mole++;
        }
        result[i]=(mole/(done));
        answer[i] = i+1;
        done -= mole;
        for(let j = 0 ; j < result.length; j++){
            if(result[j] < result[i]){
                result.splice(j, 0, result[i]);
                result.pop();
                answer.splice(j, 0, answer[i]);
                answer.pop();
            }
        }
    }
    return answer;
}