import { Component, OnInit } from '@angular/core';
import {Todo} from "../todo";
import {FormControl} from "@angular/forms";
import {TodoService} from "../todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
    this.getAll();
  }

    getAll(){
    this.todoService.getAll().subscribe( todos => {
      this.todos = todos;
    });
    }
  save() {
    let todo: Todo = {
      content : this.content.value,
      complete: false
    };
    this.todoService.save(todo).subscribe( data =>{
      alert('successfully');
    }, error => {
      console.log(error)
    }, ()=>{
      this.ngOnInit();
      this.content.reset();
    });
  }

  delete(id: number) {
    this.todoService.delete(id).subscribe( ()=> {
      alert("Successfully");
      this.ngOnInit();
    })
  }
  edit(i: number) {
    this.todoService.findById(i).subscribe( todo => {
      todo.complete = !todo.complete;
      this.todoService.edit(i, todo).subscribe(()=>{
        this.ngOnInit();
      })
    });
  }
}
