function solution(nums) {
    const max = nums.length / 2;
    const setNum = new Set(nums);

    return (max > setNum.size) ? setNum.size : max;
}