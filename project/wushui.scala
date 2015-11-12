
object wushui {
   def main(args:Array[String]){
     
     def checksum(header:String) = {
       var sum = header.split(" ").map(Integer.parseInt(_, 16)).sum;
       while(sum >= 65536){
         sum = (sum & 65535) + (sum >> 16);
       }
       val checksum = Integer.toHexString(~sum & 65535);
       header.substring(0,25) + checksum + header.substring(29);
     }
     assert(checksum("4500 0073 0000 4000 4011 0000 c0a8 0001 c0a8 00c7") == "4500 0073 0000 4000 4011 b861 c0a8 0001 c0a8 00c7")
     assert(checksum("4500 0042 3038 0000 4011 0000 c0a8 0afa af90 6ce9") == "4500 0042 3038 0000 4011 6257 c0a8 0afa af90 6ce9")
   }
   
   
}