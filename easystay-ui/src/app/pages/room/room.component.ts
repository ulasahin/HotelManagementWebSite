import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Room, RoomService } from '../../services/room.service';


@Component({
  selector: 'app-rooms',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  rooms: Room[] = [];

  constructor(private roomService: RoomService, private router: Router) {}

  ngOnInit(): void {
    this.roomService.getRooms().subscribe(
      (data: Room[]) => {
        this.rooms = data;
        console.log('Rooms:', this.rooms); // Verilerin doğru şekilde alındığını kontrol etmek için
      },
      (error) => {
        console.error('Error fetching rooms:', error);
      }
    );
  }

  reserveRoom(roomId: number): void {
    this.router.navigate(['/reserve', roomId]);
  }
}
