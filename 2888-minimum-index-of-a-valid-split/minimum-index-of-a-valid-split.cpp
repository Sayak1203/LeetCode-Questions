class Solution {
public:
    int minimumIndex(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int,int> mp;
        for( auto it: nums){
            mp[it]++;
        }
        int dom=-1,c=0;
        for(auto it: mp){
            if(it.second>n/2){
                dom=it.first;
                c=it.second;
                break;
            }
        }
        int d=0;
        for(int i=0; i<n; i++){
            if(nums[i]==dom){
                d++;
            }
            if(2*d>i+1 && 2*(c-d)>n-i-1){
                return i;
            }
        }
        // cout << dom << " " << c;
        return -1;
    }
};