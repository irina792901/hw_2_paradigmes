/**Мы разрабатываем систему управления ресурсами в офисе. У нас есть несколько комнат,
в каждой из которых размещены разные устройства (компьютеры, принтеры, лампы и т. д.).
Каждое устройство имеет следующие характеристики: тип (компьютер, принтер, лампа и т. д.),
статус (включено или выключено), идентификатор.
Мы хотим выполнить следующие операции:
Добавить новое устройство в комнату.
Включить или выключить устройство в комнате.
Поиск устройства по типу и статусу.
Получить список всех устройств в конкретной комнате.
Подсчитать общее количество устройств каждого типа в офисе.
*/

// Класс, представляющий устройство
data class Device(val id: Int, val type: String, var status: Boolean)

// Класс, представляющий комнату с устройствами
class Room(val name: String) {
    private val devices = mutableListOf<Device>()

    // Добавление нового устройства в комнату
    fun addDevice(device: Device) {
        devices.add(device)
    }

    // Включение или выключение устройства по идентификатору
    fun toggleDeviceStatus(deviceId: Int) {
        val device = devices.find { it.id == deviceId }
        device?.status = device?.status?.not() ?:false
    }

    // Поиск устройства по типу и статусу
    fun findDevicesByTypeAndStatus(type: String, status: Boolean): List<Device> {
        return devices.filter { it.type == type && it.status == status }
    }

    // Получение списка всех устройств в комнате
    fun getAllDevices(): List<Device> {
        return devices.toList()
    }

    // Подсчет общего количества устройств каждого типа в комнате
    fun countDevicesByType(): Map<String, Int> {
        val deviceCounts = mutableMapOf<String, Int>()
        for (device in devices) {
            val currentCount = deviceCounts.getOrDefault(device.type, 0)
            deviceCounts[device.type] = currentCount + 1
        }
        return deviceCounts
    }
}

// Класс, представляющий офис с комнатами
class Office {
    private val rooms = mutableListOf<Room>()

    // Добавление новой комнаты в офис
    fun addRoom(room: Room) {
        rooms.add(room)
    }

    // Получение списка всех комнат в офисе
    fun getAllRooms(): List<Room> {
        return rooms.toList()
    }
}

fun main() {
    // Создание офиса и комнат
    val office = Office()
    val room1 = Room("Комната 1")
    val room2 = Room("Комната 2")

    // Добавление комнат в офис
    office.addRoom(room1)
    office.addRoom(room2)

    // Добавление устройств в комнаты
    room1.addDevice(Device(1, "Компьютер", true))
    room1.addDevice(Device(2, "Лампа", false))
    room2.addDevice(Device(3, "Принтер", true))
    room2.addDevice(Device(4, "Лампа", true))

    // Включение или выключение устройства по идентификатору
    room1.toggleDeviceStatus(1)

    // Поиск устройств по типу и статусу
    val foundDevices = room2.findDevicesByTypeAndStatus("Лампа", true)
    println("Найденные устройства: $foundDevices")

    // Получение списка всех устройств в комнате
    val allDevicesInRoom1 = room1.getAllDevices()
    println("Устройства в комнате 1: $allDevicesInRoom1")

    // Подсчет общего количества устройств каждого типа в офисе
    val deviceCountsInOffice = office.getAllRooms()
        .flatMap { it.getAllDevices() }
        .groupBy { it.type }
        .mapValues { it.value.size }
    println("Общее количество устройств каждого типа в офисе: $deviceCountsInOffice")
}

