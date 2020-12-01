public class HashTable {
        private EmpLinkList [] empLinkList;
        private int size;
        public HashTable(int size){
            this.size=size;
            empLinkList=new EmpLinkList[size];
            for (int i=0;i<size;i++){
                empLinkList[i]=new EmpLinkList();
            }
        }

        public int hashFun(int id){
            return id%size;
        }

        public void delete(int id){
            empLinkList[hashFun(id)].delete(id);
        }
        public void find(int id){
            empLinkList[hashFun(id)].find(id);
        }
        public void add(Emp emp){
            int num=hashFun(emp.id);
            empLinkList[num].add(emp);
        }

        public void list(){
            for (int i=0;i<size;i++){
                if (empLinkList[i].isEmpty()){
                    continue;
                }
                empLinkList[i].list();
            }
        }


    }
