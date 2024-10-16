"use strict";

const tasklistWebapp = {
	htmlElements: {
		taskForm: document.querySelector(".task-form"),
		taskInput: document.querySelector(".task-input"),
		taskList: document.querySelector(".task-list"),
	},

	addTask: function (task) {
		if (task) {
			const li = this.htmlElements.taskList.appendChild(
				document.createElement("li"),
			);
			li.textContent = task;
			li.addEventListener("click", this.clickTaskListener);
		}
	},

	clickTaskListener: function () {
		this.classList.toggle("completed-task");
	},

	formListener: function (self, e) {
		e.preventDefault();
		self.addTask(self.htmlElements.taskInput.value);
		self.htmlElements.taskInput.value = "";
	},

	start: function () {
		this.htmlElements.taskForm.addEventListener("submit", e =>
			this.formListener(this, e),
		);
	},
};

tasklistWebapp.start();
