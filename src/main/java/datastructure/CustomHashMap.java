package datastructure;

/**
 * Created by BigDataEnthusiast on 3/22/2015.
 */
public class CustomHashMap {

    private static final int SIZE=16;
    private Entry[] tables = new Entry[SIZE];
    public CustomHashMap(){}

    public static void main(String[] args){
        CustomHashMap tmhm = new CustomHashMap();

        tmhm.put("MAY", "CTO");
        tmhm.put("YAM", "CMO");
        tmhm.put("AMY", "COO");
        tmhm.put("Rohini", "CEO");

        Entry e = tmhm.get("YAM");
        System.out.println(""+e.getValue());
    }

    public Entry get(String key){
        int hash = key.hashCode()%SIZE;
        hash = Math.abs(hash);
        Entry entry = tables[hash];
        while(entry.getNext() != null){
            if(entry.getKey().equals(key)){
                return entry;
            }
            entry = entry.getNext();
        }
        return entry;
    }
    public void put(String key, String value ){
        Entry<String, String> newEntry = new Entry<String, String>(key, value);
        int hash = key.hashCode()%SIZE;
        hash = Math.abs(hash);
        Entry entry = tables[hash];

        if(entry == null){
            tables[hash]=newEntry;
        }else{
            if(entry.getKey().equals(key)){
                entry.setValue(value);
            }else{
                Entry current;
                while(entry.getNext() != null){
                    current = entry.getNext();
                    entry=current;
                }
                entry.setNext(newEntry);
            }
        }




    }
    static class Entry<K,V>{
        private  K key;
        private V value;
        private Entry next;

        private Entry(K key, V value){
            this.key=key;
            this.value=value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value){
            this.value = value;
        }

        public Entry getNext() {
            return next;
        }

        public void setNext(Entry next) {
            this.next = next;
        }



    }
    /**
     * "C:\Program Files\Java\jdk1.8.0_40\bin\java" -Didea.launcher.port=7536 "-Didea.launcher.bin.path=C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\Java\jdk1.8.0_40\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_40\jre\lib\ext\zipfs.jar;C:\Users\Ajeet\IdeaProjects\JobSearch\target\classes;C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 14.0.3\lib\idea_rt.jar" com.intellij.rt.execution.application.AppMain datastructure.CustomHashMap
     CMO

     Process finished with exit code 0

     */
}
