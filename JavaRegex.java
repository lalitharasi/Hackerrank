public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
        String IP = in.next();
        System.out.println(IP.matches(new MyRegex().pattern));
    }

}class MyRegex {
    /*
     * [0-9]{1,2} matches 0-99
     * (0|1)[0-9][0-9] matches 000-199
     * 2[0-4][0-9] matches 200-249
     * 25[0-5] matches 250-255
     */
    String octet = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    
    // Concatenate the octet 4 times separated by escaped dots
    public String pattern = octet + "\\." + octet + "\\." + octet + "\\." + octet;
}
