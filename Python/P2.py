def flatten(li):
    res = []
    for eles in li:
        if isinstance(eles, list):
            res.extend(flatten(eles))
        else:
            res.append(eles)
    return res
def findSecondLargest(li):
    mx = float('-inf')
    secondMx = float('-inf')
    for i in li:
        if i>mx:
            secondMx=mx;mx = i
        elif i>secondMx and i!=mx:
            secondMx=i
    return secondMx

def mergeSort(arr):
    if len(arr)==1:
        return arr
    mid = len(arr)//2
    left  = mergeSort(arr[:mid])
    right = mergeSort(arr[mid:])
    return merge(left, right)
def merge(left, right):
    res=[]
    i=j=0
    while i<len(left) and j<len(right):
        if left[i]<right[j]:
            res.append(left[i])
            i+=1
        else:
            res.append(right[j]);j+=1
        res.extend(left[i:])
        res.extend(right[j:])
    return res