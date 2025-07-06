class Solution {
public:
    int findLucky(vector<int>& arr) {
        int n=arr.size();
        map<int,int>mpp;
        for(int i=0;i<n;i++){
            mpp[arr[i]]++;
        }
        int maxi=-1;
        for(int i=1;i<=mpp.size();i++) {
            if(mpp[i]==i){
                maxi=max(maxi, i);
            }
        }   
        return maxi;
    }
};