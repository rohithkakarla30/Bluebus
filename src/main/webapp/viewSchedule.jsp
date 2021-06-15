<!DOCTYPE html>
<html>
<head>
    <title>Add Schedule</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>
<body>
    <h2>Enter Schedule Details</h2>
    <form action="/viewSchedule" method="POST">
        <label id="source">Source</label>
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        <input type="text" name="source" id="source">
        <br>

        <label id="destination">Destination</label>
        &nbsp&nbsp
        <input type="text" name="destination" id="destination">
        <br>

        <input type="hidden" name="operation" value="viewSchedule">

        <input type="submit" value="View Schedule">
        
    </form>
</body>
</html>