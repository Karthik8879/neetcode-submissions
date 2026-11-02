class TimeMap {
    class Custom {
        String value;
        int timestamp;

        Custom(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Custom>> hm = new HashMap<>();

    public TimeMap() {
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
        }
        hm.get(key).add(new Custom(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        List<Custom> list = hm.get(key);
        if(list == null) {
            return "";
        }
        for(int i = list.size()-1; i >= 0; i--) {
            if(list.get(i).timestamp <= timestamp) {
                return list.get(i).value;
            }
        }
        return "";
    }
}
