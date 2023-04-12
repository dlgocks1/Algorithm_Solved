class Solution {
    
    enum class STATUS {
        Wating, Running;
    }
    
    data class Job(
        val job : List<Int>,
        var isDone : Boolean,
        val idx: Int,
        var processingTime: Int = 0
    )
    
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0

        var processes = jobs.mapIndexed { idx, job ->
            Job(job.toList(), false, idx)
        }
        var hdStatus = STATUS.Wating
        var processEndTime = -1
        var curTime = -1
        
        while(processes.any { !it.isDone } ) {
            curTime++
            if(curTime == processEndTime) hdStatus = STATUS.Wating
            val availableProcesses = processes.filter {
                it.isDone == false && it.job[0] <= curTime
            }
            if(availableProcesses.isEmpty()) continue
            when(hdStatus) {
                STATUS.Wating -> {
                    val nextJobIdx = availableProcesses
                        .sortedBy { it.job[1] }
                        .first()
                        .idx
                    processes[nextJobIdx].isDone = true
                    processEndTime = curTime + processes[nextJobIdx].job[1]
                    // println("job $nextJobIdx 이 끝남 $processEndTime")
                    processes[nextJobIdx].processingTime = processEndTime - processes[nextJobIdx].job[0]
                    hdStatus = STATUS.Running
                }
                STATUS.Running -> {
                    // Do Nothing
                }
            }
        }
        
        // processes.forEach {
            // println(it)
        // }
        
        return Math.floor(
            processes.sumOf { it.processingTime } / processes.size.toDouble() 
        ).toInt()
    }
}