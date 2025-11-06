class Solution {
    public List<List<String>> findLadders(String startWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        List<List<String>> res=new ArrayList<>();
        if(!dict.contains(endWord)){
            return res;
        }
        Map<String,List<String>> parent=new HashMap<>();
        Set<String> vis=new HashSet<>();
        boolean found=false;
        Queue<String> queue=new LinkedList<>();
        queue.add(startWord);
        while(!queue.isEmpty() && !found){
            int size=queue.size();
            Set<String> levelVis=new HashSet<>();
            for(int i=0;i<size;i++){
                String word=queue.poll();
                char[] ch=word.toCharArray();
                for(int j=0;j<ch.length;j++){
                    char og=ch[j];
                    for(char c='a';c<='z';c++){
                        if(c==og){
                            continue;
                        }
                        ch[j]=c;
                        String next=new String(ch);
                        if(dict.contains(next) && !vis.contains(next)){
                            parent.putIfAbsent(next,new ArrayList<>());
                            parent.get(next).add(word);
                            if(!levelVis.contains(next)){
                                queue.add(next);
                                levelVis.add(next);
                            }
                            if(next.equals(endWord)){
                                found=true;
                                break;
                            }
                        }
                    }
                    ch[j]=og;
                }
            }
            vis.addAll(levelVis);
        }
        if(found){
            List<String> path=new ArrayList<>();
            path.add(endWord);
            backtrack(res,path,parent,endWord,startWord);
        }
        return res;
    }
    public void backtrack(List<List<String>> res,List<String> path,Map<String,List<String>> parent,String word,String start){
        if(word.equals(start)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            res.add(temp);
            return ;
        }
        if(!parent.containsKey(word)){
            return;
        }
        for(String s : parent.get(word)){
            path.add(s);
            backtrack(res,path,parent,s,start);
            path.remove(path.size()-1);
        }
    }
}
