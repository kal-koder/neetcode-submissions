class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> seen = new HashMap<>(strs.length);
        for (String s: strs) {
            char[] key = s.toCharArray();
            int l = 0, h = key.length-1;
            mergeSort(key, l,h);
            String k = new String(key);
            if (seen.containsKey(k)) {
                seen.get(k).add(s);
            } else {
                seen.put(k,new ArrayList<>());
                seen.get(k).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>(seen.values());
        return res;
    }
}

void mergeSort(char[] s, int l, int h) {
    if (l>=h) {
        return;
    }
    int mid = (l+h)/2;
    mergeSort(s, l, mid);
    mergeSort(s, mid+1, h);
    merge(s,l,h,mid);
}

void merge(char[] s, int l, int h, int mid) {
    int n1 = mid - l + 1;
    int n2 = h - mid;
    
    char[] left = new char[n1];
    char[] right = new char[n2];
    int i = 0;
    int j = 0;
    int k = l;
    for (int c = 0; c < n1; c++) {
        left[c] = s[l+c];
    }
    for (int c = 0; c < n2; c++) {
        right[c] = s[mid+1+c];
    }
    
    while(i<n1 && j<n2) {
        if (left[i] < right[j]) {
            s[k] = left[i];
            i++;k++;
        } else {
            s[k] = right[j];
            j++;k++;
        }
    }

    while (i<n1) {
        s[k] = left[i];
        i++;k++;
    }
    while(j<n2) {
        s[k] = right[j];
        j++;k++;
    }
}
